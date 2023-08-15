package com.countrydemo.countryApplication.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "name", "population", "countryCode" })
public class City {
    private int id;
    private String name;
    private int population;
    private String countryCode;
}
