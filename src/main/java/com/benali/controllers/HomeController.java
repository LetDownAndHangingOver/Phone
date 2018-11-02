package com.benali.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.benali.entitites.User;
import com.benali.metier.UserMetier;

@Controller
public class HomeController {
	@Autowired
	private UserMetier UM;
	@RequestMapping(path = "/home")
	public String index(){
		return "index";
	}
	@RequestMapping(path = "/home", method=RequestMethod.POST)
	public String index2(User u){
		User user = UM.addUser(u);
		return "index";
	}
	@RequestMapping(path = "/inscription")
	public String inscription(){
		return "inscription";
	}
	@RequestMapping(path="/about")
	public String about(){
		return "about";
	}
	@RequestMapping(path="/rechercher")
	public String rechercher(Model model, String search){
		List<User> users = UM.findByKW(search);
		model.addAttribute("users", users);
		return "rechercher";
	}

}
