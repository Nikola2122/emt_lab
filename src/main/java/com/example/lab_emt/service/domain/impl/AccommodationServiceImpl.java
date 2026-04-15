package com.example.lab_emt.service.domain.impl;

import com.example.lab_emt.events.BookEvent;
import com.example.lab_emt.model.domain.Accommodation;
import com.example.lab_emt.model.enums.Category;
import com.example.lab_emt.model.enums.State;
import com.example.lab_emt.model.exception.AccNotBookableException;
import com.example.lab_emt.model.exception.AccommodationNotDeletableException;
import com.example.lab_emt.model.projection.DetailedAccProjection;
import com.example.lab_emt.repository.AccommodationRepository;
import com.example.lab_emt.service.domain.AccommodationService;
import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.lab_emt.service.domain.impl.FieldFilterSpecification.*;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.accommodationRepository = accommodationRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public Optional<Accommodation> findByIdEntityGraph(Long id) {
        return accommodationRepository.findWithHostAndCountryById(id);
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Accommodation create(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    @Override
    public Optional<Accommodation> update(Long id, Accommodation accommodation) {
        return findById(id).map(acc -> {

            acc.setName(accommodation.getName());
            acc.setCategory(accommodation.getCategory());
            acc.setHost(accommodation.getHost());
            acc.setState(accommodation.getState());
            acc.setNumRooms(accommodation.getNumRooms());
            acc.setBooked(accommodation.getBooked());

            return accommodationRepository.save(acc);
        });
    }

    @Override
    public Optional<Accommodation> deleteById(Long id) {
        Optional<Accommodation> accommodation = findById(id);
        accommodation.ifPresent(acc -> {
            if(acc.getState().equals(State.BAD)){
                accommodationRepository.delete(acc);
            }
            else {
                throw new AccommodationNotDeletableException(id);
            }
        });
        return accommodation;
    }

    @Override
    public Optional<Accommodation> book(Long id) {
        return findById(id).map(acc -> {
            if(acc.getState().equals(State.GOOD) && acc.getNumRooms() > 0){
                acc.setBooked(true);
                acc.setNumRooms(acc.getNumRooms() - 1);
                applicationEventPublisher.publishEvent(
                        new BookEvent(acc.getName(), LocalDateTime.now(), true, acc.getNumRooms() == 0, acc.getId(), acc.getHost().getId())
                );
            }
            else {
                applicationEventPublisher.publishEvent(
                        new BookEvent(acc.getName(), LocalDateTime.now(), false, acc.getNumRooms() == 0, acc.getId(), acc.getHost().getId())
                );
                throw new AccNotBookableException(id);
            }
            return accommodationRepository.save(acc);
        });
    }

    @Override
    public Page<Accommodation> findPaged(Category category, Long hostId, Long countryId, Integer numRooms, Boolean booked, Integer pageNum, Integer pageSize) {
        Specification<Accommodation> specification = Specification.allOf(
                filterEqualsV(Accommodation.class, "category", category),
                filterEquals(Accommodation.class, "host.id", hostId),
                filterEquals(Accommodation.class, "host.country.id", countryId),
                greaterThan(Accommodation.class, "numRooms", numRooms),
                filterEqualsV(Accommodation.class, "booked", booked)
        );

        return this.accommodationRepository.findAll(
                specification,
                PageRequest.of(pageNum, pageSize, Sort.by(Sort.Direction.DESC, "name").
                        and(Sort.by(Sort.Direction.DESC, "createdAt"))));
    }

    @Override
    public List<DetailedAccProjection> findDetailedProjection() {
        return accommodationRepository.findDetailedDetails();
    }
}
