package com.cognizant.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Country code is required")
    @Column(unique = true)
    private String countryCode;

    @NotBlank(message = "Country name is required")
    private String countryName;

    private String capital;
    private String currency;

    public Country() {}

    public Country(String countryCode, String countryName, String capital, String currency) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.capital = capital;
        this.currency = currency;
    }

    public Long getId() { return id; }
    public String getCountryCode() { return countryCode; }
    public String getCountryName() { return countryName; }
    public String getCapital() { return capital; }
    public String getCurrency() { return currency; }
    public void setCountryName(String n) { this.countryName = n; }
    public void setCapital(String c) { this.capital = c; }
    public void setCurrency(String c) { this.currency = c; }
}
