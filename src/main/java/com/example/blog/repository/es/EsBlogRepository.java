package com.example.blog.repository.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.blog.domain.es.EsBlog;

/**
 * EsBlog Repository 接口
 * 
 * @author admin
 *
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {
	/**
	 * 分页查询博客（ 去重）
	 * @param title
	 * @param content
	 * @param pageable
	 * @return
	 */
	Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String content, String summary,Pageable pageable);
}
