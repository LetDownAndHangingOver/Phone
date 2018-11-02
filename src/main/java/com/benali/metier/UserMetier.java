package com.benali.metier;

import java.util.List;

import org.springframework.stereotype.Service;

import com.benali.entitites.User;

@Service
public interface UserMetier {
	public User addUser(User u);
	public User findUser(String pseudo);
	public List<User> findAll();
	public List<User> findByKW(String KW);
	public void deleteUser(User u);

}
