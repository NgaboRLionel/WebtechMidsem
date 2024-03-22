package com.example.demo.Service.implementation;

import com.example.demo.Service.CountryService;
import com.example.demo.model.Country;
import com.example.demo.model.Student;
import com.example.demo.repository.CountryRepo;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public class CountryServiceImpl extends RemoteException implements CountryService {




    private CountryRepo countryRepo;
    @Override
    public void addCountry(Country country) {
        countryRepo.save(country);
    }

    @Override
    public List<Country> getCountry() throws RemoteException {
        return countryRepo.findAll();
    }

    @Override
    public void deleteCountry(UUID Id) {
        countryRepo.deleteById(Id);
    }

    @Override
    public Country findCountryByName(String name) {
        return countryRepo.findCountryByName(name);
    }

    @Override
    public Country findCountryByCode(String Code) {
        return countryRepo.findCountryByCode(Code);
    }
}
