package com.benali.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.benali.dao.ProduitRepository;
import com.benali.entitites.Produit;
@Service
public class ProduitMetierImpl implements ProduitMetier{
	@Autowired
	private ProduitRepository PR;

	@Override
	public Produit saveProduit(Produit p) {
		return PR.save(p);
	}

	@Override
	public Page<Produit> listAllProduits(Pageable page) {
		return PR.getAllProduits(page);
	}

	@Override
	public List<Produit> findProduit(String KW) {
		return PR.findByKW(KW);
	}

	@Override
	public void deleteProduit(Produit p) {
		PR.delete(p);
	}

	@Override
	public Optional<Produit> findProduitById(Long id) {
		return PR.findById(id);
	}


}
