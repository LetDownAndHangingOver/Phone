package com.benali.controllers;

import groovyjarjarasm.asm.commons.Method;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

//import ch.qos.logback.access.pattern.RequestMethodConverter;



import com.benali.entitites.Produit;
import com.benali.entitites.SmartphoneDB;
import com.benali.entitites.User;
import com.benali.metier.ProduitMetier;
import com.benali.metier.SmartPhoneMetier;
import com.benali.metier.UserMetier;

@Controller
public class ProduitController {
	@Autowired
	private ProduitMetier PM;
	@Autowired
	private UserMetier UM;

	private static String UPLOADED_FOLDER = "C:\\Users\\BMW\\Documents\\Upload\\";

	@RequestMapping(path="/listProduit")
	public String getAllProducts(Model model){
		List<Produit> products = PM.listAllProduits();
		model.addAttribute("produit", products);
		return "/listProduit";
	}
	@RequestMapping(path="/l/listproduits")
	public String getallProducts(Model model){
		List<Produit> products = PM.listAllProduits();
		model.addAttribute("produit", products);
		return "/l/listproduits";
	}
	@RequestMapping(path="/l/prod/{id}")
	public String getProduitId(@PathVariable Long id, Model model){
		Produit p = PM.findProduitById(id);
		model.addAttribute("prod", p);
		return "/l/prod";
	}
	@RequestMapping(path="/l/ajouterProduit")
	public String ajouterProduit(Model model){
		model.addAttribute("produit", new Produit());
		return "/l/ajouterProduit";
	}
	@RequestMapping(path="/l/ajouterProduit", method=RequestMethod.POST)
	public String ajouterPhotoProduitAjoute(Produit produit, Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String pseudo = auth.getName();
		User user = UM.findUser(pseudo);
		produit.setUser(user);
		PM.saveProduit(produit);
		return "/l/produit";
	}

//	@RequestMapping(path="/l/ajouterPhoto", method=RequestMethod.POST)
//	public String uploadFile(@RequestParam("file") MultipartFile file, Model model){
//		try {
//			byte[] bytes = file.getBytes();
//			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//			Files.write(path, bytes);
//		
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return"/l/Produit";
//	}


}
