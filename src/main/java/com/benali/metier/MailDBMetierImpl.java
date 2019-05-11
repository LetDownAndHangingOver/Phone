package com.benali.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benali.dao.MailDBRepository;
import com.benali.entitites.MailDB;
@Service
public class MailDBMetierImpl implements MailDBMetier{
	@Autowired
	private MailDBRepository MDBR;

	@Override
	public MailDB findMailId(Long id) {
		return MDBR.findOne(id);
	}

	@Override
	public MailDB saveMail(MailDB mdb) {
		return MDBR.save(mdb);
	}

}
