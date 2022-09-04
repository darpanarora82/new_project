package com.marketingapp.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.marketingapp.Services.LeadService;
import com.marketingapp.Utility.EmailServiceImpl;
import com.marketingapp.entities.Lead;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadServ;
	
	@Autowired
	private EmailServiceImpl emailServ;
	
	@RequestMapping("/view")
	public String createNewLead() {
		return "CreateLeadPage";
	}
	
	@RequestMapping("/createLead")
	public String createLead(@ModelAttribute("lead") Lead lead , ModelMap model , @RequestParam("text") String text) {
		leadServ.saveLead(lead);
		emailServ.sendSimpleMessage(lead.getEmail(), "New Email!!", text);
		model.addAttribute("msg", "lead is saved!!");
		return "CreateLeadPage";
	}
	
	@RequestMapping("/listAll")
	public String readAllLeads(ModelMap model) {
		List<Lead> lead = leadServ.listAll();
		model.addAttribute("lead", lead);
		return "ReadAllLeads";
	}
	
	@RequestMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("id") long id , ModelMap model) {
		leadServ.deleteById(id);
		List<Lead> lead = leadServ.listAll();
		model.addAttribute("lead", lead);
		return "ReadAllLeads";
	}
	
	@RequestMapping("/updateRecord")
	public String updateRecord(@RequestParam("id") long id , ModelMap model) {
		Lead findById = leadServ.updateRecordById(id);
		model.addAttribute("lead", findById);
		return "";
	}
	
}
