package com.example.blog.domain.es;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Blog文档
 * 
 * @author admin
 *
 */

@Document(indexName = "blog", type = "blog") // 文档
public class EsBlog implements Serializable {
	@Id // 主键
	private String id;
	private String title;//标题
	private String summary;//摘要
	private String content;//内容

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	// JPA规范要求；防止直接使用
	protected EsBlog() {

	}

	public EsBlog( String title, String summary, String content) {
		this.title = title;
		this.summary = summary;
		this.content = content;
	}

	@Override
	public String toString() {
		return "EsBlog [id=" + id + ", title=" + title + ", summary=" + summary + ", content=" + content + "]";
	}

}
