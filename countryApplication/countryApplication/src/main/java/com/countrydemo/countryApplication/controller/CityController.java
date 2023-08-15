package com.countrydemo.countryApplication.controller;

import com.countrydemo.countryApplication.model.City;
import com.countrydemo.countryApplication.model.Country;
import com.countrydemo.countryApplication.utils.manageCities;
import com.countrydemo.countryApplication.utils.manageCountries;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CityController {

    public Map<String,City> highestPopulatedCity() {
        List<Country> countryList = new manageCountries().getAllCountries();
        Map<String,City> citiesToCountry = new HashMap<>();
        for (Country country : countryList) {
            List<City> cities = new manageCities().getAllCities().stream().filter(city -> country.getCode().equals(city.getCountryCode())).collect(Collectors.toList());
            City maxPopulatedCity = cities.stream().max(Comparator.comparingInt(City::getPopulation)).get();
            citiesToCountry.put(country.getName(), maxPopulatedCity);
        }
        return citiesToCountry;
    }

    public Map<String,City> highestPopulatedContient() {
        List<Country> countryList = new manageCountries().getAllCountries();
        Map<String, List<String>> contientsToCountryCodes = new HashMap<>();
        Map<String, City> maxPopulatedCityToContient = new HashMap<>();
        for (Country country : countryList) {
            List<String> countryCodes;
            if(contientsToCountryCodes.containsKey(country.getContient())) {
                countryCodes = contientsToCountryCodes.get(country.getContient());
            } else {
                countryCodes = new ArrayList<>();
            }
            countryCodes.add(country.getCode());
            contientsToCountryCodes.put(country.getContient(), countryCodes);
        }
        contientsToCountryCodes.forEach((contient,countryCodeList) -> {
            List<City> citiesToContient = new manageCities().getAllCities().stream().filter(city -> countryCodeList.contains(city.getCountryCode())).collect(Collectors.toList());
            City maxPopulatedCity = citiesToContient.stream().max(Comparator.comparingInt(City::getPopulation)).get();
            maxPopulatedCityToContient.put(contient, maxPopulatedCity);
        });
        return maxPopulatedCityToContient;
    }

    public Map<String,City> highestPopulatedCapital() {
        List<Country> countryList = new manageCountries().getAllCountries();
        Map<String,City> citiesToCapital = new HashMap<>();
        for (Country country : countryList) {
            List<City> cities = new manageCities().getAllCities().stream().filter(city -> country.getCode().equals(city.getCountryCode())).collect(Collectors.toList());
            City maxPopulatedCity = cities.stream().max(Comparator.comparingInt(City::getPopulation)).get();
            citiesToCapital.put(country.getCapital(), maxPopulatedCity);
        }
        return citiesToCapital;
    }
}
