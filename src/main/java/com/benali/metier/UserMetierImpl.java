package com.benali.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benali.dao.UserRepository;
import com.benali.entitites.User;
@Service
public class UserMetierImpl implements UserMetier{
	@Autowired
	private UserRepository UR;

	@Override
	public User addUser(User u) {
		return UR.save(u);
	}

	@Override
	public User findUser(String pseudo) {
		return UR.findOne(pseudo);
	}

	@Override
	public List<User> findAll() {
		return UR.findAll();
	}

	@Override
	public List<User> findByKW(String KW) {
		return UR.findByKW(KW);
	}

	@Override
	public void deleteUser(User u) {
		UR.delete(u);
	}
	

}
