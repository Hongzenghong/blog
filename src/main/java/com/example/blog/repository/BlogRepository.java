package com.example.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.domain.Blog;
import com.example.blog.domain.Catalog;
import com.example.blog.domain.User;
/**
 * blog仓库
 * @author admin
 *
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {
	/**
	 * 根据用户名分页查询用户列表
	 * @param user
	 * @param title
	 * @param sort
	 * @param pageable
	 * @return
	 */
	Page<Blog> findByUserAndTitleLike(User user, String title, Pageable pageable);
	
	/**
	 *根据用户名、博客标题分页查询博客列表
	 * @param user
	 * @param title
	 * @param pageable
	 * @return
	 */
	Page<Blog> findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(String title,User user,String tags,User user2,Pageable pageable);
	/**
	 * 根据用户名分页查询用户列表
	 * @param user
	 * @param title
	 * @param sort
	 * @param pageable
	 * @return
	 */
	Page<Blog> findByCatalog(Catalog catalog, Pageable pageable);

}
