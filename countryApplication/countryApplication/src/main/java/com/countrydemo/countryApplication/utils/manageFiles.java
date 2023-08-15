package com.countrydemo.countryApplication.utils;

import com.countrydemo.countryApplication.model.City;
import com.countrydemo.countryApplication.model.Country;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class manageFiles {

    public File readFileByName(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }
        File file = new File(resource.getFile());

        return file;
    }

}
