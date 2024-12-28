package com.gfg.spring.boot.app.repository;

import com.gfg.spring.boot.app.model.SubCounty;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface SubCountyRepository extends CrudRepository<SubCounty, Integer> {
    Iterable<SubCounty> findSubCountiesByCountyCode(String countyCode);

    @Query("select sub_county.id, sub_county.name, sub_county.sub_county_code, sub_county.county_code from sub_county " +
            "inner join county on sub_county.county_code = county.county_code where county.name=:countyName")
    Iterable<SubCounty> findSubCountiesByCountyName(String countyName);
}
