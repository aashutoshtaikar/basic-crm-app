package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Customer;
import com.demo.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//list the customers and show homepage
	@GetMapping("/list")
	public ModelAndView getHomepage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customers", customerService.getCustomers());
		mv.setViewName("list-customers");
		return mv;
	}
	
	@GetMapping("/showAddForm")
	public ModelAndView showAddForm() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customer", new Customer());
		mv.setViewName("form-customer");
		return mv;
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam("id") Integer id) {
		Customer customer = customerService.getCustomer(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("customer", customer);
		mv.setViewName("form-customer");
		return mv;
		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customers/list";
	}
	
	@GetMapping("/deleteCustomer")
	public ModelAndView deleteCustomer(@RequestParam("id") Integer id) {
		customerService.deleteCustomer(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/customers/list");
		return mv;	
	}
	
	@GetMapping("/searchCustomers")
	public ModelAndView searchCustomers(@RequestParam("theSearchName") String theSearchName) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customers", customerService.searchCustomer(theSearchName));
		mv.setViewName("list-customers");
		return mv;
	}
}
