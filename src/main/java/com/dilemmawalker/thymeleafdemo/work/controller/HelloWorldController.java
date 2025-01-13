package com.dilemmawalker.thymeleafdemo.work.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //show initial html form
    //@RequestMapping is more generic & allows all kinds of requests
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //process html form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //read form data & add data to model
    @RequestMapping("/processFormVersion2")
    public String letsShoutDude(HttpServletRequest request, Model model){

        //read request from HTML form
        String name = request.getParameter("studentName");

        //convert data to all uppsercase
        name = name.toUpperCase();

        //create message
        String result = "Yo! " + name;

        //add message to model
        model.addAttribute("message", result);
        //we can add any type of java entity to model be it String, object, etc.

        return "helloworld";
    }

    @GetMapping("/processFormVersion3")
    public String processFormVersion3(@RequestParam("studentName") String name, Model model){
        name = name.toUpperCase();

        //create message
        String result = "Yo!, v3 here " + name;

        //add message to model
        model.addAttribute("message", result);
        //we can add any type of java entity to model be it String, object, etc.

        return "helloworld";
    }

}
