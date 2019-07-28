package com.company.examplefortests.thirdexample;

import java.util.ArrayList;

public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository repository) {
        userRepository = repository;
    }

    public ArrayList<User> getAll() {
        return userRepository.getAll();
    }

    public User findOneUser(Long id) {
        return userRepository.findOneUser(id);
    }

    public Integer getCountOfUsers() {
        return userRepository.getAll().size();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
