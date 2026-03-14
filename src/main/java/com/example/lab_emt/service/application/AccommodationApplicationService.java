package com.example.lab_emt.service.application;

import com.example.lab_emt.model.dto.RequestAccommodationDto;
import com.example.lab_emt.model.dto.ResponseAccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationApplicationService {
    Optional<ResponseAccommodationDto> findById(Long id);

    List<ResponseAccommodationDto> findAll();

    ResponseAccommodationDto create(RequestAccommodationDto requestAccommodationDto);

    Optional<ResponseAccommodationDto> update(Long id, RequestAccommodationDto requestAccommodationDto);

    Optional<ResponseAccommodationDto> deleteById(Long id);

    Optional<ResponseAccommodationDto> book(Long id);
}
