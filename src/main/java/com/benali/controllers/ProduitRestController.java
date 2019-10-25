package com.benali.controllers;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benali.entitites.Produit;
import com.benali.excel.ExcelGenerator;
import com.benali.excel.ExcelPhone;
import com.benali.metier.ProduitMetier;

@Controller
@RequestMapping("/l")
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
	@GetMapping(value="/l/download")
	public ResponseEntity<InputStreamResource> excelCustoersReport(List<ExcelPhone> listPhones){
		//list of phones
		ByteArrayInputStream in;
			in = eg.generateExcel(listPhones);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachement; filename=generatedPhones.xlsx");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}

}
