package com.dilemmawalker.thymeleafdemo.work.controller;

import com.dilemmawalker.thymeleafdemo.work.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showForm(Model model){
        //having model in initial controller helps with retaining value to be used later in view template.

        //create a new student object
        Student student = new Student();

        //add student object to model
        model.addAttribute("student", student);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student){
        //here "student" signifies the form object type, since name is same, spring is able to inject entire Student class inside model which we receive here.

        //log input data
        System.out.println("student: "+ student + ", firstName: "+ student.getFirstName() + ", last Name: "+ student.getLastName());

        return "student-confirmation";
    }
}
