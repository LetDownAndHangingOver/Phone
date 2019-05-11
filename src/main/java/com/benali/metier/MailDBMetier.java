package com.benali.metier;

import org.springframework.stereotype.Service;

import com.benali.entitites.MailDB;

@Service
public interface MailDBMetier {
	public MailDB findMailId(Long id);
	public MailDB saveMail(MailDB mdb);
	

}
