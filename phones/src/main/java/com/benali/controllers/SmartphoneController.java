package com.benali.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.benali.entitites.ComparateurForm;
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
		model.addAttribute("comp", new ComparateurForm());
		return "/l/comparateur";
	}
	@RequestMapping(path="/l/comparateur2", method=RequestMethod.POST)
	public String comparateur2(Model model, SmartphoneDB sdb){
		Optional<SmartphoneDB> s = SM.findProduitById(sdb.getIdSmartPhone());
		List<SmartphoneDB> smarts2 = SM.listAllSmartphone();
		model.addAttribute("sdb2", new SmartphoneDB());
		model.addAttribute("sdb1", sdb);
		model.addAttribute("smarts1", s);
		model.addAttribute("smarts2", smarts2);
		model.addAttribute("compsdb", new ComparateurForm());
		return "/l/comparateur2";
	}
	@RequestMapping(path="/l/com", method=RequestMethod.POST)
	public String com(Model model, SmartphoneDB smarts1, SmartphoneDB sdb2, ComparateurForm comp){
		Optional<SmartphoneDB> s1 = SM.findProduitById(comp.getIdsmart1());
		Optional<SmartphoneDB> s2 = SM.findProduitById(comp.getIdsmart2());
		System.out.println(s1.get().getNomSmartPhone());
		System.out.println(s2.get().getNomSmartPhone());
		model.addAttribute("smart", s1);
		model.addAttribute("smart2", s2);
		return "/l/com";
	}

}
