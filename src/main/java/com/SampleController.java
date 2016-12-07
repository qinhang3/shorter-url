package com;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hang.qin on 2016/12/7.
 */

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!!!!";
    }

    @RequestMapping("/useTemplate")
    public String useTemplate(Model model) {
        model.addAttribute("output","helloworld!!!!!!!");
        return "helloworld";
    }
}