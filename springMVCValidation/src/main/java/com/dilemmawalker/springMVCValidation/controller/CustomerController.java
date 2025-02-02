package com.dilemmawalker.springMVCValidation.controller;

import com.dilemmawalker.springMVCValidation.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        //true signifies if entire string is just empty spaces, trim it to null.
        //StringTrimmerEditor removes whitespace -> leading & trailing

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String formDisplay(Model model){

        model.addAttribute("customer", new Customer());
        //required because we are using html form data-binding

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult){
    //binding result holds result of validation like errors etc.

        if(bindingResult.hasErrors()){
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
