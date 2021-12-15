package com.example.usersLogins.Service;

import java.util.List;

import com.example.usersLogins.Dao.UserDAO;
import com.example.usersLogins.Entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        List<User> listUsers = userDAO.findAll();
        return listUsers;
    }

    @Override
    public User findById(int id) {
        User user = userDAO.findById(id);
        return user;
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void deleteByID(int id) {
        userDAO.deleteById(id);
    }

}
