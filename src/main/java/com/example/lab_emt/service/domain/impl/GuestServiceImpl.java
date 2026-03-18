package com.example.lab_emt.service.domain.impl;

import com.example.lab_emt.model.domain.Guest;
import com.example.lab_emt.model.domain.Host;
import com.example.lab_emt.repository.GuestRepository;
import com.example.lab_emt.service.domain.GuestService;
import com.example.lab_emt.service.domain.HostService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;
    private final HostService hostService;

    public GuestServiceImpl(GuestRepository guestRepository, HostService hostService) {
        this.guestRepository = guestRepository;
        this.hostService = hostService;
    }

    @Override
    public Optional<Guest> findById(Long id) {
        return guestRepository.findById(id);
    }

    @Override
    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    @Override
    public Guest create(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public Optional<Guest> update(Long id, Guest guest) {
        return findById(id).map(g -> {
            g.setName(guest.getName());
            g.setSurname(guest.getSurname());

            return g;
        });
    }

    @Override
    public Optional<Guest> deleteById(Long id) {
        Optional<Guest> guest = findById(id);
        guest.ifPresent(guestRepository::delete);
        return guest;
    }

    @Override
    @Transactional
    public Optional<Guest> addGuestToHost(Long guest_id, Long host_id) {
        return findById(guest_id).map(g -> {
            Optional<Host> host = hostService.findById(host_id);
            host.ifPresent(h -> g.getHosts().add(h));
            host.ifPresent(h -> h.getGuests().add(g));
            return g;
        });
    }
}
