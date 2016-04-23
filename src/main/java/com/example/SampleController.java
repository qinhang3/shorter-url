package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @RequestMapping(value="/{user}", method=RequestMethod.GET)
    @ResponseBody
    public String getUser(@PathVariable String user) {
        return user;
    }

    @RequestMapping(value="/city", method=RequestMethod.GET)
    @ResponseBody
    public String getCity() {
        Pageable pageable = new PageRequest(1,10);
        Page<City> cities = cityRepository.findAll(pageable);
        StringBuilder stringBuilder = new StringBuilder();
        for (City city : cities) {
            stringBuilder.append(city);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}