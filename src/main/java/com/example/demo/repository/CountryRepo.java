package com.example.demo.repository;

import com.example.demo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CountryRepo extends JpaRepository<Country, UUID> {
    @Query("SELECT c from Country c where c.name =: name")
    Country findCountryByName (@Param("name") String name);

    @Query("SELECT c from Country c where c.Code =: Code")
    Country findCountryByCode (@Param("Code") String Code);
}
