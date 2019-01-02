package com.example.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.blog.domain.Blog;
import com.example.blog.domain.Catalog;
import com.example.blog.domain.Comment;
import com.example.blog.domain.User;
import com.example.blog.domain.Vote;
import com.example.blog.repository.BlogRepository;

/**
 * Blog服务
 * 
 * @author admin
 *
 */
@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogRepository blogRepository;

	@Transactional
	@Override
	public Blog saveBlog(Blog blog) {
		// 新增
		Blog returnBlog = blogRepository.save(blog);
		return returnBlog;
	}

	@Transactional
	@Override
	public void removeBlog(Long id) {
		// 删除
		blogRepository.delete(id);
	}

	@Transactional
	@Override
	public Blog updateBlog(Blog blog) {
		// 更新
		return blogRepository.save(blog);
	}

	@Override
	public Blog getBlogById(Long id) {
		// 根据id查询
		return blogRepository.findOne(id);
	}

	@Override
	public Page<Blog> listBlogsByTitleVote(User user, String title, Pageable pageable) {
		// 根据用户名进行分页模糊查询（最新）
		title = "%" + title + "%";
		String tags = title;
		Page<Blog> blogs = blogRepository.findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(title,user, tags,user, pageable);
		return blogs;

	}

	@Override
	public Page<Blog> listBlogsByTitleVoteAndSort(User user, String title, Pageable pageable) {
		// 根据用户名进行分页模糊查询（最热）
		title = "%" + title + "%";
		Page<Blog> blogs = blogRepository.findByUserAndTitleLike(user, title, pageable);
		return blogs;
	}

	@Override
	public void readingIncrease(Long id) {
		// 阅读量递增
		Blog blog = blogRepository.findOne(id);
		blog.setReadSize(blog.getReadSize() + 1);//在原有阅读量基础上递增1
		blogRepository.save(blog);
	}

	@Override
	public Blog createComment(Long blogId, String commentContent) {
		Blog originalBlog = blogRepository.findOne(blogId);
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		Comment comment = new Comment(user, commentContent);
		originalBlog.addComment(comment);
		return blogRepository.save(originalBlog);
	}

	@Override
	public void removeComment(Long blogId, Long commentId) {
		Blog originalBlog = blogRepository.findOne(blogId);
		originalBlog.removeComment(commentId);
		blogRepository.save(originalBlog);
		
	}

	@Override
	public Blog createVote(Long blogId) {
		Blog originalBlog = blogRepository.findOne(blogId);
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		Vote vote = new Vote(user);
		boolean isExist = originalBlog.addVote(vote);
		if (isExist) {
			throw new IllegalArgumentException("该用户已经点过赞了");
		}
		return blogRepository.save(originalBlog);
	}

	@Override
	public void removeVote(Long blogId, Long voteId) {
		Blog originalBlog = blogRepository.findOne(blogId);
		originalBlog.removeVote(voteId);
		blogRepository.save(originalBlog);
		
	}

	@Override
	public Page<Blog> listBlogsByCatalog(Catalog catalog, Pageable pageable) {
		Page<Blog> blogs = blogRepository.findByCatalog(catalog, pageable);
		return blogs;
	}

}
