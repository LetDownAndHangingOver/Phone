package com.benali.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Produit> listAllProduits() {
		return PR.findAll();
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
	public Produit findProduitById(Long id) {
		return PR.findOne(id);
	}

}
