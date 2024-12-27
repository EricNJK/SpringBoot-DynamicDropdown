package com.gfg.spring.boot.app.repository;

import com.gfg.spring.boot.app.model.County;
import org.springframework.data.repository.CrudRepository;

public interface CountyRepository extends CrudRepository<County, Integer> {
}
