package com.countrydemo.countryApplication.utils;

import com.countrydemo.countryApplication.model.Country;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class manageCountries {

    static String filename = "Countries.csv";
    public List<Country> getAllCountries() {
        List<Country> countries;
        try {
            File csvFile = new manageFiles().readFileByName(filename);
            CsvSchema csvSchema = new CsvMapper()
                    .typedSchemaFor(Country.class)
                    .withHeader()
                    .withColumnSeparator(',')
                    .withComments();

            MappingIterator<Country> complexUsersIter = new CsvMapper()
                    .readerWithTypedSchemaFor(Country.class)
                    .with(csvSchema)
                    .readValues(csvFile);

            countries = complexUsersIter.readAll();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countries;
    }
}
