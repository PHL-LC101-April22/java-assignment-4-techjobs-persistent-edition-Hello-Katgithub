package org.launchcode.techjobs.persistent.controllers;

import org.jboss.jandex.Index;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {
//    public Index index;

// add index method responds at /employers list of all database.
    @Autowired
    private EmployerRepository employerRepository;

    // findAll, save, findById

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("employers", employerRepository.findAll());
        return "employers/index";
    }

     @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
         model.addAttribute("title", "Add Employer");
        model.addAttribute(new Employer());
        return "employers/add";
    }

    //#3 data layer: save a valid object
    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("employers", "Add Employer");
            return "employers/add";
        }
        employerRepository.save(newEmployer);
        return "redirect:";
    }

    // #4 data layer: displayViewEmployer
    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {
         model.addAttribute("Employer ID", "Create Employer ID");
         model.addAttribute(new Employer());
         model.addAttribute("employers", employerRepository.findById(employerId));

        Optional optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employers", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }

        }
    }

