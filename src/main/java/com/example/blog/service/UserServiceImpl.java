package com.example.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.blog.domain.User;
import com.example.blog.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Override
	public User saveOrUpateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	@Transactional
	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	@Transactional
	@Override
	public void removeUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}
	
	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public Page<User> listUsersByNameLike(String name, Pageable pageable) {
		// 模糊查询
		name = "%" + name + "%";
		Page<User> users = userRepository.findByNameLike(name, pageable);
		return users;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		return userRepository.findByUsername(username);
	}

}
