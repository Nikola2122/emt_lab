package com.example.lab_emt.service.domain.impl;

import com.example.lab_emt.model.domain.Accommodation;
import com.example.lab_emt.model.domain.Country;
import com.example.lab_emt.model.enums.State;
import com.example.lab_emt.model.exception.AccommodationNotDeletableException;
import com.example.lab_emt.repository.CountryRepository;
import com.example.lab_emt.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        return findById(id).map(acc -> {

            acc.setName(country.getName());
            acc.setContinent(country.getContinent());

            return countryRepository.save(acc);
        });
    }

    @Override
    public Optional<Country> deleteById(Long id) {
        Optional<Country> country = findById(id);
        country.ifPresent(countryRepository::delete);
        return country;
    }
}
