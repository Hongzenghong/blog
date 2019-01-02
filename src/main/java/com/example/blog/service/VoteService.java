package com.example.blog.service;

import com.example.blog.domain.Vote;

/**
 * vote 服务接口
 * 
 * @author admin
 *
 */
public interface VoteService {
	/**
	 * 根据id获取Vote
	 * 
	 * @param id
	 * @return
	 */
	Vote getVoteById(Long id);

	/**
	 * 删除Vote
	 * 
	 * @param id
	 */
	void removeVote(Long id);
}
