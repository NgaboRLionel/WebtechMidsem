package com.example.demo.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(unique = true)
    private String Code;
    private String name;

    public Country() {
    }

    public Country(UUID id, String code, String name) {
        Id = id;
        Code = code;
        this.name = name;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
