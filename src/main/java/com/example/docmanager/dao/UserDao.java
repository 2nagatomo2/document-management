package com.example.docmanager.dao;

import com.example.docmanager.entity.User;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import java.util.Optional;

@Dao
@ConfigAutowireable
public interface UserDao {

    @Select
    Optional<User> findById(Long id);

    @Select
    Optional<User> findByEmail(String email);

    @Select
    Optional<User> findByUsername(String username);

    @Select
    List<User> findAll();

    @Insert
    int insert(User user);

    @Update
    int update(User user);

    @Delete
    int delete(User user);
}