package com.example.demo.controller;

import com.example.demo.Service.CountryService;
import com.example.demo.model.Country;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

@Controller
public class CountryController {

    private CountryService countryService;

    @GetMapping("/country")
    public String listCountries(Model model) throws RemoteException{
        List<Country> countries = countryService.getCountry();
        model.addAttribute("country",countries);
        return "countryDisplay";
    }
    @GetMapping("/addCountry")
    public String addCtr(Model model){
        Country country = new Country();
        model.addAttribute("country",country);
        return "country";
    }
    @GetMapping("/saveCountry")
    public String saveStudent(@ModelAttribute("country") Country country){
        countryService.addCountry(country);
        return "redirect:/country";
    }
    @GetMapping("/deleteCountry/{Id}")
    public String deleteCountry(@PathVariable(value = "Id") UUID Id){
        this.countryService.deleteCountry(Id);
        return "redirect:/country";
    }

}
