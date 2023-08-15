package com.countrydemo.countryApplication.utils;

import com.countrydemo.countryApplication.model.City;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class manageCities {

    static String filename = "Cities.csv";

    public List<City> getAllCities() {
        List<City> cities = null;
        try {
            File csvFile = new manageFiles().readFileByName(filename);
            CsvSchema csvSchema = new CsvMapper()
                    .typedSchemaFor(City.class)
                    .withHeader()
                    .withColumnSeparator(',');

            MappingIterator<City> cityMappingIterator = new CsvMapper()
                    .readerWithTypedSchemaFor(City.class)
                    .with(csvSchema)
                    .readValues(csvFile);

            cities = cityMappingIterator.readAll();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }

}
