package com.benali.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.benali.entitites.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	@Query("select u from User u where u.Pseudo like %:x%")
	public List<User> findByKW(@Param("x")String KW);
}
