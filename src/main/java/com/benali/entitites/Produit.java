package com.benali.entitites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produit implements Serializable{
	@Id
	private Long idProduit;
	private String nomProduit;
	private String photoProduit;
	private String prix;
	@ManyToOne
	@JoinColumn(name="nomUser")
	private User user;
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(Long idProduit, String nomProduit) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public String getPhotoProduit() {
		return photoProduit;
	}
	public void setPhotoProduit(String photoProduit) {
		this.photoProduit = photoProduit;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
