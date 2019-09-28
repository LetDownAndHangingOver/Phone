package com.benali.excel;

public class ExcelPhone {
	private Long idSmartEx;
	private String nomSmartEx;
	private int prixSmartEx;
	private String RAMSmartEx;
	public Long getIdSmartEx() {
		return idSmartEx;
	}
	public void setIdSmartEx(Long idSmartEx) {
		this.idSmartEx = idSmartEx;
	}
	public String getNomSmartEx() {
		return nomSmartEx;
	}
	public void setNomSmartEx(String nomSmartEx) {
		this.nomSmartEx = nomSmartEx;
	}
	public int getPrixSmartEx() {
		return prixSmartEx;
	}
	public void setPrixSmartEx(int prixSmartEx) {
		this.prixSmartEx = prixSmartEx;
	}
	public String getRAMSmartEx() {
		return RAMSmartEx;
	}
	public void setRAMSmartEx(String rAMSmartEx) {
		RAMSmartEx = rAMSmartEx;
	}
	public ExcelPhone(String nomSmartEx, int prixSmartEx, String rAMSmartEx) {
		super();
		this.nomSmartEx = nomSmartEx;
		this.prixSmartEx = prixSmartEx;
		RAMSmartEx = rAMSmartEx;
	}
	
	
}
