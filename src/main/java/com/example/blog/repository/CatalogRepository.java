package com.example.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.domain.Catalog;
import com.example.blog.domain.User;
/**
 * 分类 仓库
 * @author admin
 *
 */
public interface CatalogRepository  extends JpaRepository<Catalog, Long> {
	/**
	 * 根据用户查询
	 * @param user
	 * @return
	 */
	List<Catalog> findByUser(User user);
	
	/**
	 * 根据用户、分类名查询
	 * @param user
	 * @param name
	 * @return
	 */
	List<Catalog> findByUserAndName(User user,String name);
}
