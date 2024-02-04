package com.stock.services;

import java.util.List;
import com.stock.model.User;

public interface UserService {
	public User save(User u);
	public List<User> findAll();	
	public User update(User u);
	public void deleteById(Long id);
	public User findById(Long id);
	
	//TODO: ?
	//public User findByName(String n);
}
