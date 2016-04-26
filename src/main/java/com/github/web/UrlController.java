package com.github.web;

import com.github.data.UrlDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hang on 16/4/24.
 */
@Controller
@EnableAutoConfiguration
public class UrlController {
    @Autowired
    private UrlDAO urlDAO;

    @RequestMapping(value = "/{code}")
    public String getUrlByCode(@PathVariable String code){
        Long id = Long.valueOf(code,16);
        return "code";
    }
}
