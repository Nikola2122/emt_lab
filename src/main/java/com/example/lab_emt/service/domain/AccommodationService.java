package com.example.lab_emt.service.domain;

import com.example.lab_emt.model.domain.Accommodation;
import com.example.lab_emt.model.domain.Country;
import com.example.lab_emt.model.dto.ResponseAccommodationDto;
import com.example.lab_emt.model.enums.Category;
import com.example.lab_emt.model.projection.DetailedAccProjection;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    Optional<Accommodation> findById(Long id);
    Optional<Accommodation> findByIdEntityGraph(Long id);

    List<Accommodation> findAll();

    Accommodation create(Accommodation accommodation);

    Optional<Accommodation> update(Long id, Accommodation accommodation);

    Optional<Accommodation> deleteById(Long id);

    Optional<Accommodation> book(Long id);

    Page<Accommodation> findPaged
            (Category category, Long hostId, Long countryId, Integer numRooms, Boolean booked,
             Integer pageNum, Integer pageSize);

    List<DetailedAccProjection> findDetailedProjection();

}
