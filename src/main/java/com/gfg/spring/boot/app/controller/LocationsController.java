package com.gfg.spring.boot.app.controller;

import com.gfg.spring.boot.app.model.County;
import com.gfg.spring.boot.app.repository.CountyRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// Name in guide: DBController
@RestController
@CrossOrigin
public class LocationsController {

    private final CountyRepository repository;

    public LocationsController(CountyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/counties")
    public List<County> counties() {
        ArrayList<County> counties = new ArrayList<>();
        repository.findAll().forEach(cty -> counties.add(cty));
        return counties;
    }
}
