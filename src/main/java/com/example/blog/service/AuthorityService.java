package com.example.blog.service;

import com.example.blog.domain.Authority;

/**
 * 权限服务接口
 * 
 * @author admin
 *
 */
public interface AuthorityService {
	/**
	 * 根据id查询权限
	 * @param id
	 * @return
	 */
	Authority getAuthorityById(Long id);
}
