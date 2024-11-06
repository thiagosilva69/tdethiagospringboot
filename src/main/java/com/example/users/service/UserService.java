package com.example.users.service;

import com.example.users.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "José", 23, "jose@gmail.com");
        User user2 = new User(2, "Joao", 23, "joao@gmail.com");
        User user3 = new User(3, "Joyce", 23, "joyce@gmail.com");
        User user4 = new User(4, "Luis", 25, "luis@gmail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4));
    }

    public Optional<User> getUserById(Integer id) {
        Optional<User> optional = Optional.empty();

        for(User user: userList) {
            if(id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }

        return optional;
    }
    public List<User> getAllUsers() {
        return userList;
    }


    public User addUser(User user) {
        userList.add(user);
        return user;
    }
    public User updateUser(Integer id, User updatedUser) {
        Optional<User> existingUser = getUserById(id);

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(updatedUser.getName());
            user.setAge(updatedUser.getAge());
            user.setEmail(updatedUser.getEmail());
            return user;
        }

        return null;
    }

    public boolean deleteUser(Integer id) {
        return userList.removeIf(user -> user.getId() == id);
    }
}