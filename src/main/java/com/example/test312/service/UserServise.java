package com.example.test312.service;



import com.example.test312.model.User;

import java.util.List;

public interface UserServise {

    void addUser(User user);

    List<User> listUsers();

    void updateUser(User user);

    void removeUser(int id);

    User getUserById(int id);

}
