package com.benali.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.benali.entitites.SmartphoneDB;
import com.benali.metier.SmartPhoneMetier;

@Controller
public class SmartphoneController {
	@Autowired
	SmartPhoneMetier SM;
	
	@RequestMapping(path="/l/comparateur", method=RequestMethod.GET)
	public String comparateur(Model model){
		List<SmartphoneDB> smarts = SM.listAllSmartphone();
		model.addAttribute("smarts", smarts);
		model.addAttribute("sdb", new SmartphoneDB());
		return "/l/comparateur";
	}
	@RequestMapping(path="/l/comparateur2", method=RequestMethod.POST)
	public String comparateur2(Model model, SmartphoneDB sdb){
		SmartphoneDB s = SM.findProduitById(sdb.getIdSmartPhone());
		List<SmartphoneDB> smarts2 = SM.listAllSmartphone();
		model.addAttribute("smarts1", s);
		model.addAttribute("smarts2", smarts2);
		return "/l/comparateur2";
	}
	@RequestMapping(path="/l/com")
	public String com(Model model, SmartphoneDB sdb2){
		SmartphoneDB s2 = SM.findProduitById(sdb2.getIdSmartPhone());
		model.addAttribute("smart2", s2);
		return "/l/com";
	}

}
