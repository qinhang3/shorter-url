package com.example;

/**
 * Created by hang on 16/4/23.
 */
import org.springframework.data.domain.*;
import org.springframework.data.repository.*;

public interface CityRepository extends Repository<City, Long> {

    Page<City> findAll(Pageable pageable);

    int count();

//    Page<City> findByNameAll(Pageable pageable,String name);

    City findByNameAndStateAllIgnoringCase(String name, String state);
}


