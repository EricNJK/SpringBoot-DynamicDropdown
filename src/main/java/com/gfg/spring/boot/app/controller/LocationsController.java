package com.gfg.spring.boot.app.controller;

import com.gfg.spring.boot.app.model.County;
import com.gfg.spring.boot.app.model.SubCounty;
import com.gfg.spring.boot.app.model.Village;
import com.gfg.spring.boot.app.repository.CountyRepository;
import com.gfg.spring.boot.app.repository.SubCountyRepository;
import com.gfg.spring.boot.app.repository.VillageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

// Name in guide: DBController
@Controller
@CrossOrigin
public class LocationsController {

    private final CountyRepository countyRepository;
    private final SubCountyRepository subCountyRepository;
    private final VillageRepository villageRepository;

    public LocationsController(CountyRepository countyRepository, SubCountyRepository subCountyRepository, VillageRepository villageRepository) {
        this.countyRepository = countyRepository;
        this.subCountyRepository = subCountyRepository;
        this.villageRepository = villageRepository;
    }

    @GetMapping("/")
    public String countiesThymeleaf(Model model) {
        ArrayList<County> counties = new ArrayList<>();
        countyRepository.findAll()
                .forEach(cty -> counties.add(cty));
        model.addAttribute("countyList", counties);
        return "counties_page.html";
    }

    @GetMapping("/counties")
    @ResponseBody
    public List<County> counties() {
        ArrayList<County> counties = new ArrayList<>();
        countyRepository.findAll()
                .forEach(cty -> counties.add(cty));
        return counties;
    }

    @GetMapping("/sub-counties")
    @ResponseBody
    public List<SubCounty> subCountiesByCountyName(@RequestParam("countyName") String countyName) {
        ArrayList<SubCounty> subCounties = new ArrayList<>();
        subCountyRepository.findSubCountiesByCountyName(countyName)
                .forEach(subCounty -> subCounties.add(subCounty));
        return subCounties;
    }

    @GetMapping("/villages")
    @ResponseBody
    public List<Village> villages(@RequestParam("subCountyCode") String subCountyCode) {
        ArrayList<Village> villages = new ArrayList<>();
        villageRepository.findVillagesBySubCountyCode(subCountyCode).forEach(village -> villages.add(village));
        return villages;
    }
}
