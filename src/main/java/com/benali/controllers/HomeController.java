package com.benali.controllers;

import io.undertow.attribute.RequestMethodAttribute;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.benali.entitites.Produit;
import com.benali.entitites.User;
import com.benali.metier.ProduitMetier;
import com.benali.metier.UserMetier;

@Controller
public class HomeController {
	@Autowired
	private UserMetier UM;
	@Autowired
	private ProduitMetier PM;
	@RequestMapping(path = "/home")
	public String index(){
		return "index";
	}
	@RequestMapping(path="/l/home")
	public String index2(User user){
//		User user = UM.addUser(u);
		return "l/index";
	}
	@RequestMapping(path="/inscription", method=RequestMethod.GET)
	public String inscription(Model model){
		model.addAttribute("user", new User());
		return "inscription";
	}
	@RequestMapping(path = "/inscription", method=RequestMethod.POST)
	public String inscription(User user){
		if(user != null){
			if(UM.findUser(user.getPseudo()) == null){		
				UM.addUser(user);
				return "inscrit";
			}
		}
		return "index";
	}
//	@RequestMapping(path="/connexion", method=RequestMethod.GET)
//	public String connexion(){
//		return "connexion";
//	}
	@RequestMapping(path="/about")
	public String about(){
		return "about";
	}
	@RequestMapping(path="/rechercher")
	public String rechercher(Model model, String search){
		List<User> users = UM.findByKW(search);
		List<Produit> produits = PM.findProduit(search);
		model.addAttribute("produits", produits);
		model.addAttribute("users", users);
		return "rechercher";
	}

	@RequestMapping(path="/fail")
	public String fail(){
		return "fail";
	}


}
