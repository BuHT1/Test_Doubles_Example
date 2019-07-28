package com.company.examplefortests.thirdexample;

import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> allUsers = null; //Get all users from DB
        return allUsers;
    }

    @Override
    public User findOneUser(Long id) {
        return null; //Find user in DB, return user
    }
}
