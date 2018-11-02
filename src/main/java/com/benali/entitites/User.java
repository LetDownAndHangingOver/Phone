package com.benali.entitites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable{
	@Id
	private String Pseudo;
	private String PassWord;
	private String Mail;
	private String Photo;
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private Collection<Produit> produits;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String pseudo, String passWord, String mail) {
		super();
		Pseudo = pseudo;
		PassWord = passWord;
		Mail = mail;
	}
	public String getPseudo() {
		return Pseudo;
	}
	public void setPseudo(String pseudo) {
		Pseudo = pseudo;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public Collection<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	} 

	
}
