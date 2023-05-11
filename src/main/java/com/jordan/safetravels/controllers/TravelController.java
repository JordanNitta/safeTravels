package com.jordan.safetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jordan.safetravels.models.Travel;
import com.jordan.safetravels.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelController {
	
	@Autowired
	private TravelService travelservice;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String home(Model model) {
		//GETTING DATA FROM DB
		List<Travel> allExpense = travelservice.allTravel();
		//ASSIGNING DATA TO VARIABLE TO BE REFERENCED IN HTML
		model.addAttribute("allExpense", allExpense);
		
		Travel expense = new Travel();
		//SENDING OBJECT TO ASSIGN TO INCOMING FORM
		model.addAttribute("expense", expense);
		return "expenses.jsp";
	}
	
	
	@PostMapping("/process/expenses")
	public String expenses(
//		This submits its from the modelAttribute from the form side
		@Valid @ModelAttribute("expense") Travel travel, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()) {
			model.addAttribute("expenses", travelservice.allTravel());
			return "expenses.jsp";
		}
		
		travelservice.createTravel(travel);
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id")Long id,Model model) {
		model.addAttribute("expenses", travelservice.findOne(id));
		return "edit.jsp";
	}
	
	@GetMapping("/expenses/{id}")
	public String getOne(@PathVariable("id") long id, Model model) {
		model.addAttribute("expense", travelservice.findOne(id));
		System.out.println(travelservice.findOne(id));
		return "show.jsp";
	}
	
//  Update
	@PutMapping("/process/edit/{id}")
	public String processEditExpenses(
		@Valid @ModelAttribute("expenses") 
		Travel travel, 
		BindingResult result, 
		@PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		travelservice.updateTravel(travel);
		return "redirect:/expenses/"+id;
	}
	
//	Delete 
	@DeleteMapping("/delete/{id}")
	public String deleteDonation(@PathVariable("id") Long id) {
		travelservice.delete(id);
		return "redirect:/expenses";
	}
	
}
