package com.example.lab_emt.service.application;

import com.example.lab_emt.model.dto.RequestAccommodationDto;
import com.example.lab_emt.model.dto.RequestGuestDto;
import com.example.lab_emt.model.dto.ResponseAccommodationDto;
import com.example.lab_emt.model.dto.ResponseGuestDto;

import java.util.List;
import java.util.Optional;

public interface GuestApplicationService {
    Optional<ResponseGuestDto> findById(Long id);

    List<ResponseGuestDto> findAll();

    ResponseGuestDto create(RequestGuestDto requestGuestDto);

    Optional<ResponseGuestDto> update(Long id, RequestGuestDto requestGuestDto);

    Optional<ResponseGuestDto> deleteById(Long id);

    Optional<ResponseGuestDto> addGuestToHost(Long guest_id, Long host_id);
}
