package com.bimo.bimo.service;

import com.bimo.bimo.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    User saveUser(User user);
    User getUser(String id);
    Page<User> listUser(Pageable pageable);
    int updateUserById(String username, int sex, int age, String id);
    int deleteUserById(String id);
    User getUserByUsername(String username);
    User getUserById(String id);
    boolean existsUserById(String id);
    void deleteAttentionById(String user_id, String author_id);
    boolean existsByUsername(String username);
}
