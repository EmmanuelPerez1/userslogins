package com.example.usersLogins.Service;

import java.util.List;

import com.example.usersLogins.Entity.User;

public interface UserService {
    public List<User> findAll();

    public User findById(int id);
    public void save(User user);
    public void deleteByID(int id);
}
