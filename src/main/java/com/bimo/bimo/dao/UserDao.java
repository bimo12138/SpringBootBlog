package com.bimo.bimo.dao;

import com.bimo.bimo.pojo.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, String> {
    @Override
    @Transactional
    List<User> findAll();

    @Override
    @Transactional
    List<User> findAll(Sort sort);

    @Override
    @Transactional
    List<User> findAllById(Iterable<String> iterable);

    @Override
    @Transactional
    <S extends User> List<S> saveAll(Iterable<S> iterable);

    @Override
    void flush();

    @Override
    @Transactional
    <S extends User> S saveAndFlush(S s);

    @Override
    @Transactional
    void deleteInBatch(Iterable<User> iterable);

    @Override
    @Transactional
    void deleteAllInBatch();

    @Override
    @Transactional
    User getOne(String aLong);

    @Override
    <S extends User> List<S> findAll(Example<S> example);

    @Override
    <S extends User> List<S> findAll(Example<S> example, Sort sort);

    @Modifying
    @Query(value = "UPDATE auth SET username = ?1, sex = ?2, age = ?3 WHERE id = ?4", nativeQuery = true)
    public int updateUserById(String username, int sex, int age, String id);

    @Modifying
    @Query(value = "DELETE FROM auth WHERE id = ?1", nativeQuery = true)
    public int deleteUserById(String id);

    public User getUserByUsername(String username);

    public boolean existsUserById(String id);

    public boolean existsByUsername(String username);
}
