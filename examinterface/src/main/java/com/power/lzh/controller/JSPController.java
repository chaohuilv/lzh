package com.power.lzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPController {

    @PostMapping(value = "/index")
    public String index() {
        return "index";
    }
}
