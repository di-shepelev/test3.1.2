package com.example.test312.service;

import com.example.test312.dao.UserDao;
import com.example.test312.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class UserServicelmpl implements UserServise {
    private final UserDao userDao;

    public UserServicelmpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Override
    @Transactional
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Override
    @Transactional
    public void removeUser(int id) {
        userDao.removeUser(id);
    }
    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
