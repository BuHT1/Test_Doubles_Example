package com.company.examplefortests.thirdexample;

import java.util.ArrayList;

public interface UserRepository {
    ArrayList<User> getAll();
    User findOneUser(Long id);
    //More method's
}
