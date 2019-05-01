package com.benali.metier;

import java.util.List;

import org.springframework.stereotype.Service;

import com.benali.entitites.Produit;

@Service
public interface ProduitMetier {
	public Produit saveProduit(Produit p);
	public List<Produit> listAllProduits();
	public List<Produit> findProduit(String KW);
	public Produit findProduitById(Long id);
	public void deleteProduit(Produit p);
}
