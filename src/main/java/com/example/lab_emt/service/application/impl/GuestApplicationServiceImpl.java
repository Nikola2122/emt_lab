package com.example.lab_emt.service.application.impl;

import com.example.lab_emt.model.dto.RequestGuestDto;
import com.example.lab_emt.model.dto.ResponseAccommodationDto;
import com.example.lab_emt.model.dto.ResponseGuestDto;
import com.example.lab_emt.repository.GuestRepository;
import com.example.lab_emt.service.application.GuestApplicationService;
import com.example.lab_emt.service.domain.GuestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestApplicationServiceImpl implements GuestApplicationService {

    private final GuestService guestService;

    public GuestApplicationServiceImpl(GuestService guestService) {
        this.guestService = guestService;
    }


    @Override
    public Optional<ResponseGuestDto> findById(Long id) {
        return guestService
                .findById(id)
                .map(ResponseGuestDto::from);
    }

    @Override
    public List<ResponseGuestDto> findAll() {
        return ResponseGuestDto.from(guestService.findAll());
    }

    @Override
    public ResponseGuestDto create(RequestGuestDto requestGuestDto) {
        return ResponseGuestDto.from(guestService.create(requestGuestDto.toGuest()));

    }

    @Override
    public Optional<ResponseGuestDto> update(Long id, RequestGuestDto requestGuestDto) {
        return guestService.
                update(id, requestGuestDto.toGuest())
                .map(ResponseGuestDto::from);
    }

    @Override
    public Optional<ResponseGuestDto> deleteById(Long id) {
        return guestService.deleteById(id).map(ResponseGuestDto::from);
    }

    @Override
    public Optional<ResponseGuestDto> addGuestToHost(Long guest_id, Long host_id) {
        return guestService.addGuestToHost(guest_id, host_id).map(ResponseGuestDto::from);
    }

}
