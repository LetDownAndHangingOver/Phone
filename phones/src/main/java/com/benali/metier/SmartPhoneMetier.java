package com.benali.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.benali.entitites.SmartphoneDB;

@Service
public interface SmartPhoneMetier {
	public SmartphoneDB saveProduit(SmartphoneDB s);
	public List<SmartphoneDB> listAllSmartphone();
	public Optional<SmartphoneDB> findProduitById(Long id);
	public void deleteProduit(SmartphoneDB s);

}
