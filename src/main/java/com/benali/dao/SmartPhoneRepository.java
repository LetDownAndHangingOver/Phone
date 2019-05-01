package com.benali.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benali.entitites.SmartphoneDB;

public interface SmartPhoneRepository extends JpaRepository<SmartphoneDB, Long> {

}
