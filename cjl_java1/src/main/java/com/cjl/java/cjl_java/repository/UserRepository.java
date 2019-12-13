package com.cjl.java.cjl_java.repository;

import com.cjl.java.cjl_java.domain.User;

import java.util.List;

public interface UserRepository {
    User saveOrUpdateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);
    List<User> userList();
}
