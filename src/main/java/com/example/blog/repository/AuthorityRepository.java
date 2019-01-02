package com.example.blog.repository;
/**
 * 权限仓库
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
