package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @Autowired
    private NewCityRepository newCityRepository;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!!!!";
    }

    @RequestMapping(value="/{user}", method=RequestMethod.GET)
    @ResponseBody
    public String getUser(@PathVariable String user) {
        return user;
    }

    @RequestMapping(value="/city", method=RequestMethod.GET)
    @ResponseBody
    public String getCity() {
//        Pageable pageable = new PageRequest(1,10);
        List<City> cities = newCityRepository.findAll();
        StringBuilder stringBuilder = new StringBuilder();
        cities.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    @RequestMapping(value="/countCity", method=RequestMethod.GET)
    @ResponseBody
    public String getCountCity() {
        return String.valueOf(newCityRepository.count());
    }

//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(SampleController.class, args);
//    }
}