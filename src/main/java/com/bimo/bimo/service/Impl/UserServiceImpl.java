package com.bimo.bimo.service.Impl;

import com.bimo.bimo.dao.UserDao;
import com.bimo.bimo.pojo.User;
import com.bimo.bimo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userDao.saveAndFlush(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userDao.existsByUsername(username);
    }

    @Override
    @Transactional
    public User getUser(String id) {
        return userDao.getOne(id);
    }

    @Override
    @Transactional
    public Page<User> listUser(Pageable pageable) {
        return null;
    }

    @Override
    @Transactional
    public int updateUserById(String username, int sex, int age, String id) {
        return userDao.updateUserById(username, sex, age, id);
    }

    @Override
    @Transactional
    public int deleteUserById(String id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public User getUserById(String id) {
        return userDao.getOne(id);
    }

    @Override
    public boolean existsUserById(String id) {
        return userDao.existsUserById(id);
    }

    @Override
    public void deleteAttentionById(String user_id, String author_id) {
        User user = getUserById(user_id);
        User author = getUserById(author_id);
        user.getLover().remove(author);
        userDao.saveAndFlush(user);
    }
}
