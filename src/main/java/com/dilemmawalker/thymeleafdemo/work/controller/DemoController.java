package com.dilemmawalker.thymeleafdemo.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    //create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("theDate", java.time.LocalDateTime.now());

        //this returned value signifies the file position from where to return template
        //in this case it's within default("resources/templates") + advanced("/helloworld.html")
        return "helloworld";
    }
}
