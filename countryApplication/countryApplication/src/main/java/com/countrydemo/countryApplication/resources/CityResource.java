package com.countrydemo.countryApplication.resources;

import com.countrydemo.countryApplication.controller.CityController;
import com.countrydemo.countryApplication.model.City;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/cities")
public class CityResource {

    @Autowired
    CityController cityController;

    @GetMapping("highest-populated")
    Map<String,City> highestPopulatedCity() {
        return cityController.highestPopulatedCity();
    }

    @GetMapping("highest-populated-contient")
    Map<String,City> highestPopulatedContient() {
        return cityController.highestPopulatedContient();
    }

    @GetMapping("highest-populated-capital")
    Map<String,City> highestPopulatedCapital() {
        return cityController.highestPopulatedCapital();
    }
}
