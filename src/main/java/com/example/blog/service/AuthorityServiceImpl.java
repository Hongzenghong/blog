package com.example.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.domain.Authority;
import com.example.blog.repository.AuthorityRepository;
/**
 * 权限服务接口实现
 * @author admin
 *
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
@Autowired
private AuthorityRepository authorityRepository;
	@Override
	public Authority getAuthorityById(Long id) {
		// TODO Auto-generated method stub
		return authorityRepository.findOne(id);
	}

}
