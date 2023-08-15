package com.countrydemo.countryApplication.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Data;

@Data
@JsonPropertyOrder({ "code", "name", "contient", "population", "capital" })
public class Country implements Serializable {
    private String code;
    private String name;
    private String contient;
    private int population;
    private String capital;

}


