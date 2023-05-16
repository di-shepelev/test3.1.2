package com.example.test312.dao;

import com.example.test312.model.User;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class UserDaolmpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public List<User> listUsers() {

        return entityManager.createQuery("select u from User u", User.class).getResultList();

    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public void removeUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

}
