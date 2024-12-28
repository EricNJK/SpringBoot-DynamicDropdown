package com.gfg.spring.boot.app.repository;

import com.gfg.spring.boot.app.model.Village;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface VillageRepository extends CrudRepository<Village, Integer> {
    Iterable<Village> findVillagesBySubCountyCode(String subCountyCode);

    @Query("select village.id, village.name, village.sub_county_code from village inner join sub_county on village.sub_county_code = sub_county.sub_county_code where sub_county.name=:subCountyName")
    Iterable<Village> findVillagesBySubCountyName(String subCountyName);
}
