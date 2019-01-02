package com.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.domain.Vote;
/**
 * 
 * @author admin
 *
 */
public interface VoteRepository extends JpaRepository<Vote, Long> {

}
