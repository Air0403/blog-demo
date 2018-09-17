package com.zyt.repository;

import com.zyt.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User Repository 接口
 */
public interface UserRepository extends JpaRepository<User, Long> {
    // 根据用户姓名分页查询用户列表
    Page<User> findByNameLike(String name, Pageable pageable);
    // 根据用户账号查询用户
    User findByUsername(String username);
}
