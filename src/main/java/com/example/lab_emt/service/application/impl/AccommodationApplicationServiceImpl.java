package com.example.lab_emt.service.application.impl;

import com.example.lab_emt.model.domain.Host;
import com.example.lab_emt.model.dto.PagedAccRequestDto;
import com.example.lab_emt.model.dto.RequestAccommodationDto;
import com.example.lab_emt.model.dto.ResponseAccommodationDto;
import com.example.lab_emt.model.enums.Category;
import com.example.lab_emt.model.exception.HostNotFoundException;
import com.example.lab_emt.model.projection.DetailedAccProjection;
import com.example.lab_emt.service.application.AccommodationApplicationService;
import com.example.lab_emt.service.domain.AccommodationService;
import com.example.lab_emt.service.domain.HostService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {
    private final AccommodationService accommodationService;
    private final HostService hostService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, HostService hostService) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
    }


    @Override
    public Optional<ResponseAccommodationDto> findById(Long id) {
        return accommodationService
                .findById(id)
                .map(ResponseAccommodationDto::from);
    }

    @Override
    public Optional<ResponseAccommodationDto> findByIdEntityGraph(Long id) {
        return accommodationService.findByIdEntityGraph(id)
                .map(ResponseAccommodationDto::from);
    }

    @Override
    public List<ResponseAccommodationDto> findAll() {
        return ResponseAccommodationDto.from(accommodationService.findAll());
    }

    @Override
    public ResponseAccommodationDto create(RequestAccommodationDto requestAccommodationDto) {
        Host host = hostService
                .findById(requestAccommodationDto.hostId())
                .orElseThrow(() -> new HostNotFoundException(requestAccommodationDto.hostId()));
        return ResponseAccommodationDto.from(accommodationService.create(requestAccommodationDto.toAccommodation(host)));

    }

    @Override
    public Optional<ResponseAccommodationDto> update(Long id, RequestAccommodationDto requestAccommodationDto) {
        Host host = hostService
                .findById(requestAccommodationDto.hostId())
                .orElseThrow(() -> new HostNotFoundException(requestAccommodationDto.hostId()));
        return accommodationService
                .update(id, requestAccommodationDto.toAccommodation(host))
                .map(ResponseAccommodationDto::from);
    }

    @Override
    public Optional<ResponseAccommodationDto> deleteById(Long id) {
        return accommodationService
                .deleteById(id)
                .map(ResponseAccommodationDto::from);
    }

    @Override
    public Optional<ResponseAccommodationDto> book(Long id) {
        return accommodationService
                .book(id)
                .map(ResponseAccommodationDto::from);
    }

    @Override
    public Page<ResponseAccommodationDto> findAllPaged(PagedAccRequestDto requestDto) {
        return accommodationService.findPaged(requestDto.category(),
                        requestDto.hostId(),
                        requestDto.countryId(), requestDto.numRooms(), requestDto.booked(), requestDto.pageNum(),
                        requestDto.pageSize())
                .map(ResponseAccommodationDto::from);
    }

    @Override
    public List<DetailedAccProjection> findDetailedProjection() {
        return accommodationService.findDetailedProjection();
    }
}
