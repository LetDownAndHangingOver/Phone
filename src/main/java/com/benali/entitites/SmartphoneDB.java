package com.benali.entitites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SmartphoneDB implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSmartPhone;
	private String nomSmartPhone;
	private int prixSmartPhone;
	private String RAMSmartPhone;
	
	public SmartphoneDB() {
		super();
	}
	public SmartphoneDB(String nomSmartPhone, int prixSmartPhone,
			String RAMSmartPhone) {
		super();
		this.nomSmartPhone = nomSmartPhone;
		this.prixSmartPhone = prixSmartPhone;
		this.RAMSmartPhone = RAMSmartPhone;
	}
	public Long getIdSmartPhone() {
		return idSmartPhone;
	}
	public void setIdSmartPhone(Long idSmartPhone) {
		this.idSmartPhone = idSmartPhone;
	}
	public String getNomSmartPhone() {
		return nomSmartPhone;
	}
	public void setNomSmartPhone(String nomSmartPhone) {
		this.nomSmartPhone = nomSmartPhone;
	}
	public int getPrixSmartPhone() {
		return prixSmartPhone;
	}
	public void setPrixSmartPhone(int prixSmartPhone) {
		this.prixSmartPhone = prixSmartPhone;
	}
	public String getRAMSmartPhone() {
		return RAMSmartPhone;
	}
	public void setRAMSmartPhone(String rAMSmartPhone) {
		RAMSmartPhone = rAMSmartPhone;
	}

}
