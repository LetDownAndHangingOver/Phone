package com.benali.metier;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.benali.entitites.MailDB;

@Service
public interface MailDBMetier {
	public Optional<MailDB> findMailId(Long id);
	public MailDB saveMail(MailDB mdb);
	

}
