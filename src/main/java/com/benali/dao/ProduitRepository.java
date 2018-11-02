package com.benali.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.benali.entitites.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{
	@Query("select p from Produit p where p.nomProduit like %:y%")
	public List<Produit> findByKW(@Param("y") String KW);

}
