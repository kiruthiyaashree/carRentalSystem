package com.example.carRental.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.carRental.Model.Carrental;
import com.example.carRental.service.CarrentalService;

@Controller
public class CarrentalController {
	@Autowired
	private CarrentalService carrentalservice;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listCars",carrentalservice.getAllCars());
		return "index";
	}
	@GetMapping("/showNewCarRegisterForm")
	public String showNewCarRegisterForm(Model model)
	{
		Carrental carrental = new Carrental();
		model.addAttribute("carrental",carrental);
		return "new_car";
	}
	@PostMapping("/saveCars")
	public String saveCars(@ModelAttribute("carrental") Carrental carrental)
	{
		carrentalservice.saveCars(carrental);
		return "redirect:/";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value ="id") long id ,Model model)
	{
		Carrental carrental = carrentalservice.getCarrentalById(id);
		model.addAttribute("carrental",carrental);
		return "update_car";
	}
	@GetMapping("/deleteCars/{id}")
	public String deleteCarrentalById(@PathVariable(value = "id") long id)
	{
		this.carrentalservice.deleteCarrentalById(id);
		return "redirect:/";
	}
}
