package com.benali.entitites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable{
	@Id
	private String pseudo;
	private String passWord;
	private String mail;
	private String photo;
	private boolean actived;
	
	public User(String pseudo, String passWord, String mail, boolean actived) {
		super();
		this.pseudo = pseudo;
		this.passWord = passWord;
		this.mail = mail;
		this.actived = actived;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private Collection<Produit> produits;
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Role> roles;
	
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String pseudo, String passWord, String mail) {
		super();
		this.pseudo = pseudo;
		this.passWord = passWord;
		this.mail = mail;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Collection<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	} 
	

	
}
