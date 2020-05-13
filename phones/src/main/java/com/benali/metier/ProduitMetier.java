package com.benali.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.benali.entitites.Produit;

@Service
public interface ProduitMetier {
	public Produit saveProduit(Produit p);
	public Page<Produit> listAllProduits(Pageable page);
	public List<Produit> findProduit(String KW);
	public Optional<Produit> findProduitById(Long id);
	public void deleteProduit(Produit p);
}
