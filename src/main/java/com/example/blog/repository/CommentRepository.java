package com.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.domain.Comment;
/**
 * 评论仓库
 * @author admin
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
