package com.benali.entitites;

public class ContactForm {
	private String nomContact;
	private String emailContact;
	private String messageContact;
	public ContactForm(String nomContact, String emailContact,
			String messageContact) {
		super();
		this.nomContact = nomContact;
		this.emailContact = emailContact;
		this.messageContact = messageContact;
	}
	public ContactForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNomContact() {
		return nomContact;
	}
	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}
	public String getEmailContact() {
		return emailContact;
	}
	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}
	public String getMessageContact() {
		return messageContact;
	}
	public void setMessageContact(String messageContact) {
		this.messageContact = messageContact;
	}
	

}
