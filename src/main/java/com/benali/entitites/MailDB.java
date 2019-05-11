package com.benali.entitites;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MailDB {
	@Id
	private Long idMailDB;
	private String adresseMailDB;
	private String pswMailDB;
	public MailDB() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MailDB(String adresseMailDB, String pswMailDB) {
		super();
		this.adresseMailDB = adresseMailDB;
		this.pswMailDB = pswMailDB;
	}
	public Long getIdMailDB() {
		return idMailDB;
	}
	public void setIdMailDB(Long idMailDB) {
		this.idMailDB = idMailDB;
	}
	public String getAdresseMailDB() {
		return adresseMailDB;
	}
	public void setAdresseMailDB(String adresseMailDB) {
		this.adresseMailDB = adresseMailDB;
	}
	public String getPswMailDB() {
		return pswMailDB;
	}
	public void setPswMailDB(String pswMailDB) {
		this.pswMailDB = pswMailDB;
	}
	

}
