package com.example.demo.Service;

import com.example.demo.model.Country;
import com.example.demo.model.Student;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public interface CountryService {
    public void addCountry(Country country);
    public List<Country> getCountry() throws RemoteException;
    public void deleteCountry(UUID Id);
    public Country findCountryByName(String name);
    public Country findCountryByCode(String Code);

}
