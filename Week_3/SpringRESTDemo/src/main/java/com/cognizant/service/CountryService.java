package com.cognizant.service;

import com.cognizant.entity.Country;
import com.cognizant.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Optional<Country> getByCountryCode(String code) {
        return countryRepository.findByCountryCode(code);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(Long id, Country updated) {
        Country existing = countryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Country not found with id: " + id));
        existing.setCountryName(updated.getCountryName());
        existing.setCapital(updated.getCapital());
        existing.setCurrency(updated.getCurrency());
        return countryRepository.save(existing);
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
