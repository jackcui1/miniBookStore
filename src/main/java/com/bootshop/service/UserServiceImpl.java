package com.bootshop.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootshop.model.User;
import com.bootshop.repository.RoleRepository;
import com.bootshop.repository.UserRepository;
import com.bootshop.service.UserService;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Override
	public void save(User user) {
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		roleRepository.save(user.getRole());
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}


}
