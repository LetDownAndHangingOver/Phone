package com.benali.controllers;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.RequestMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.benali.entitites.Produit;
import com.benali.excel.ExcelGenerator;
import com.benali.excel.ExcelPhone;
import com.benali.metier.ProduitMetier;

@RestController
public class ProduitRestController {
	@Autowired
	ProduitMetier PM;
	@Autowired
	ExcelGenerator eg;
//	@RequestMapping("/total")
//	public List<Produit> total (){
//		List<Produit> products = PM.listAllProduits(); 
//		return products;
//	}
	
	@RequestMapping(value="/l/download")
	public ResponseEntity<InputStreamResource> excelCustomersReport(HttpServletRequest req,
								@RequestParam(value="uri") String ur){
		int page;
		page = Integer.parseInt(ur.substring(16));
		Pageable pageable = new PageRequest(page - 1, 15);
		Page<Produit> pageProduit = PM.listAllProduits(pageable);
		//Page de ArrayList
		List <Produit> produitList = pageProduit.getContent();
		List<ExcelPhone> listPhones = new ArrayList<ExcelPhone>();
		for(Produit p : produitList){
			ExcelPhone ep = new ExcelPhone();
			ep.setNomSmartEx(p.getNomProduit());
			ep.setPrixSmartEx(Integer.parseInt(p.getPrix()));
			ep.setRAMSmartEx(p.getDescription());
			listPhones.add(ep);
		}
		ByteArrayInputStream in;
			in = eg.generateExcel(listPhones);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachement; filename=generatedPhones.xlsx");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}

}
