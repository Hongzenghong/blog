package com.example.blog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

/**
 * 权限
 * 
 * @author admin
 *
 */
@Entity
public class Authority implements GrantedAuthority {
	private static final long serialVersionUID = 1L;
	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	private Long id;// 用户的唯一标识
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false) // 映射为字段，值不能为空
	private String name;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}

}
