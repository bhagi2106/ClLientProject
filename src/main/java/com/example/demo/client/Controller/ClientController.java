package com.example.demo.client.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.client.Model.Client;
import com.example.demo.client.Service.ClientService;



@Controller

public class ClientController {
	@Autowired
	private ClientService service;
	@GetMapping("/")
	public String viewHomePage(Model m)
	{
		m.addAttribute("listClients", service.getAllClients());
		return "index";
		
	}
	@GetMapping("/showNewClientForm")
	public String showNewClientForm(Model model) {
	    // Create a model attribute to bind form data
	    Client client = new Client();
	    model.addAttribute("client", client);
	    return "new_client"; // Ensure "new_client" matches the template name
	}

	@PostMapping("/saveClient")
	public String saveClient(@ModelAttribute("client") Client client)
	{
		//save employee to database
		service.saveClient(client);
		return "redirect:/";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable("id") long id, Model model) {
	    // Get client from the service
	    Client client = service.getClientById(id);
	    model.addAttribute("client", client);
	    return "update_client"; // Ensure "update_client" matches the template name for updating
	}
	@GetMapping("/deleteClient/{id}")
	public String deleteClient(@PathVariable("id") long id)
	{
		//call delete client method
		this.service.deleteClientById(id);
		return "redirect:/";
		
	}
	

	
}
