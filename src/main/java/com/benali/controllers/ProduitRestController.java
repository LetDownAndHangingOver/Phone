package com.benali.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benali.entitites.Produit;
import com.benali.metier.ProduitMetier;

@RestController
public class ProduitRestController {
	@Autowired
	ProduitMetier PM;
	
	@RequestMapping("/total")
	public List<Produit> total (){
		List<Produit> products = PM.listAllProduits();
		return products;
	}

}
