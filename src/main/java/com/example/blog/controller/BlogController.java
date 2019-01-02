package com.example.blog.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.domain.es.EsBlog;
import com.example.blog.repository.es.EsBlogRepository;

/**
 * blog控制器
 * 
 * @author admin
 *
 */
@RestController
@RequestMapping("/blogs")
public class BlogController {
//	@Autowired
//	private EsBlogRepository esBlogRepository;
//@GetMapping
//	public List<EsBlog> list(@RequestParam(value = "title") String title,
//			@RequestParam(value = "summary") String summary, @RequestParam(value = "content") String content,
//			@RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex,
//			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
//		Pageable pageable = new PageRequest(pageIndex, pageSize);
//		Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(
//				title, content, summary, pageable);
//		return page.getContent();
	
	@GetMapping
	public String listBlogs(@RequestParam(value="order",required=false,defaultValue="new") String order,
			@RequestParam(value="keyword",required=false) Long keyword) {
		System.out.print("order:" +order + ";keyword:" +keyword );
		return "redirect:/index?order="+order+"&keyword="+keyword;
	}

	

}
