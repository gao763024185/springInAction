package com.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


/**
 * Created by 高保红 on 2017/8/4.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/",method = GET)
    public String home(){
        return "home";
    }
}
