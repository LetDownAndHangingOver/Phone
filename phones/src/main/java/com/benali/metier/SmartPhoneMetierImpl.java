package com.benali.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benali.dao.SmartPhoneRepository;
import com.benali.entitites.SmartphoneDB;
@Service
public class SmartPhoneMetierImpl implements SmartPhoneMetier {
	@Autowired
	SmartPhoneRepository SR;

	@Override
	public SmartphoneDB saveProduit(SmartphoneDB s) {
		return SR.save(s);
	}

	@Override
	public List<SmartphoneDB> listAllSmartphone() {
		return SR.findAll();
	}

	@Override
	public Optional<SmartphoneDB> findProduitById(Long id) {
		return SR.findById(id);
	}

	@Override
	public void deleteProduit(SmartphoneDB s) {
		SR.delete(s);
	}

}
