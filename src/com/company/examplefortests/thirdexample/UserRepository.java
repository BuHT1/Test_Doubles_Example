package com.company.examplefortests.thirdexample;

import java.util.ArrayList;

public interface UserRepository {
    ArrayList<User> getAll();
    User findOneUser(Long id);
    void save(User user);
    //More method's
}
