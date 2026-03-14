package com.example.lab_emt.service.domain.impl;

import com.example.lab_emt.model.domain.Accommodation;
import com.example.lab_emt.model.enums.State;
import com.example.lab_emt.model.exception.AccNotBookableException;
import com.example.lab_emt.model.exception.AccommodationNotDeletableException;
import com.example.lab_emt.repository.AccommodationRepository;
import com.example.lab_emt.service.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
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
            if(acc.getState().equals(State.GOOD)){
                acc.setBooked(true);
            }
            else {
                throw new AccNotBookableException(id);
            }
            return accommodationRepository.save(acc);
        });
    }
}
