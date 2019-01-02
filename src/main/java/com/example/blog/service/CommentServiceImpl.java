package com.example.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.domain.Comment;
import com.example.blog.repository.CommentRepository;
/**
 * Comment service接口实现
 * @author admin
 *
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public Comment getCommentById(Long id) {
		return commentRepository.findOne(id);
	}

	@Override
	public void removeComment(Long id) {
		// TODO Auto-generated method stub
		commentRepository.delete(id);
	}

}
