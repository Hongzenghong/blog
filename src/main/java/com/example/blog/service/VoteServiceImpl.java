package com.example.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.domain.Vote;
import com.example.blog.repository.VoteRepository;

/**
 * vote 服务接口实现
 * @author admin
 *
 */
@Service
public class VoteServiceImpl  implements VoteService{
@Autowired 
private VoteRepository voteRepository ;

	@Override
	public Vote getVoteById(Long id) {
		// TODO Auto-generated method stub
		return voteRepository.findOne(id);
	}

	@Override
	public void removeVote(Long id) {
		// TODO Auto-generated method stub
		voteRepository.delete(id);
	}

}
