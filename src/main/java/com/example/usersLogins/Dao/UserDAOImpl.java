package com.example.usersLogins.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.usersLogins.Entity.User;

@Repository
public class UserDAOImpl implements UserDAO{
    
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAll(){
        Session currentSession = entityManager.unwrap(Session.class);

        Query<User> theQuery = currentSession.createQuery("from User", User.class);

        List<User> users = theQuery.getResultList();

        return users;
    }

    @Override
    public User findById(int id){
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(User.class, id);
    }

    @Override
    public void save(User user){
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(user);

    }

    @Override
    public void deleteById(int id){
        Session currentSession = entityManager.unwrap(Session.class);
        
        Query<User> theQuery = currentSession.createQuery("DELETE FROM Users WHERE ID =:idUser");

        theQuery.setParameter("idUser", id);
        theQuery.executeUpdate();
    }
}
