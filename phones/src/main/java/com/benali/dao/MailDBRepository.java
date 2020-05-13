package com.benali.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benali.entitites.MailDB;

public interface MailDBRepository extends JpaRepository<MailDB, Long>{

}
