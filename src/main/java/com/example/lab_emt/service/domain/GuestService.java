package com.example.lab_emt.service.domain;

import com.example.lab_emt.model.domain.Guest;
import com.example.lab_emt.model.domain.Host;

import java.util.List;
import java.util.Optional;

public interface GuestService {
    Optional<Guest> findById(Long id);

    List<Guest> findAll();

    Guest create(Guest guest);

    Optional<Guest> update(Long id, Guest guest);

    Optional<Guest> deleteById(Long id);

    Optional<Guest> addGuestToHost(Long guest_id, Long host_id);
}
