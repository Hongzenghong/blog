package com.example.blog.service;

import com.example.blog.domain.Comment;

/**
 * Comment service接口
 * 
 * @author admin
 *
 */
public interface CommentService {
	/**
	 * 根据id获取Comment
	 * 
	 * @param id
	 * @return
	 */
	Comment getCommentById(Long id);

	/**
	 * 删除评论
	 * 
	 * @param id
	 */
	void removeComment(Long id);
}
