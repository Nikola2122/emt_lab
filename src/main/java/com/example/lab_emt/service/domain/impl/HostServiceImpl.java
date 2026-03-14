package com.example.lab_emt.service.domain.impl;

import com.example.lab_emt.model.domain.Host;
import com.example.lab_emt.repository.HostRepository;
import com.example.lab_emt.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Host create(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public Optional<Host> update(Long id, Host host) {
        return findById(id).map(h -> {
            h.setName(host.getName());
            h.setSurname(host.getSurname());
            h.setCountry(host.getCountry());

            return hostRepository.save(h);
        });
    }

    @Override
    public Optional<Host> deleteById(Long id) {
        Optional<Host> host = findById(id);
        host.ifPresent(hostRepository::delete);
        return host;
    }
}
