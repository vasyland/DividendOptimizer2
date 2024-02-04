package com.stock.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.stock.exceptions.ScenarioNotFoundException;
import com.stock.model.User;
import com.stock.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(final UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
	
	@Override
	public User save(final User u) {
		return userRepository.save(u);
	}

	/**
	 * Update existing user data
	 */
	@Override
	public User update(final User u) {
		User existingUser = userRepository.findById(u.getId()).orElse(null);
		if (existingUser == null) {
			return userRepository.save(u);
		}
		existingUser.setEmail(u.getEmail());
		existingUser.setFirstName(u.getFirstName());
		existingUser.setLastName(u.getLastName());
		existingUser.setUserName(u.getUserName());
		existingUser.setPassword(u.getPassword());
		existingUser.setUpdatedOn(LocalDateTime.now());
		return userRepository.save(existingUser);
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ScenarioNotFoundException("User by id " + id + " was not found"));
	}
}
