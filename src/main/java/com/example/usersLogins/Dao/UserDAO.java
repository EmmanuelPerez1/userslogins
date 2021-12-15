package com.example.usersLogins.Dao;

import java.util.List;

import com.example.usersLogins.Entity.User;

public interface UserDAO {
    public List<User> findAll();
    public User findById(int id);
    public void save(User user);
    public void deleteById(int id);
}
