package com.company.examplefortests.thirdexample;


import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UserServiceTest {

    class FakeUserRepository implements UserRepository {

        HashMap<Long, User> allUsers = new HashMap<Long, User>() {
            {
                put(1L, new User(1L, "John", "Johnson"));
                put(2L, new User(2L, "Mike", "Mikeson"));
                put(3L, new User(3L, "Jack", "Jackson"));
            }
        };


        @Override
        public ArrayList<User> getAll() {
            return new ArrayList<User>(allUsers.values());
        }

        @Override
        public User findOneUser(Long id) {
            return allUsers.get(id);
        }

        @Override
        public void save(User user) {
            allUsers.put(user.getId(), user);
        }
    }


    @Test
    public void testGetAll() {
        //Given
        FakeUserRepository fakeUserRepository = new FakeUserRepository();
        UserService service = new UserService(fakeUserRepository);

        //When
        ArrayList<User> actualUsers = service.getAll();

        //Then
        assertEquals(fakeUserRepository.allUsers.size(), actualUsers.size());
    }

    @Test
    public void testFindOneUser() {
        //Given
        FakeUserRepository fakeUserRepository = new FakeUserRepository();
        UserService service = new UserService(fakeUserRepository);

        //When
        User actualUser = service.findOneUser(2L);

        //Then
        assertEquals(fakeUserRepository.findOneUser(2L), actualUser);
    }

    @Test
    public void testGetCountOfUsers() {
        //Given
        FakeUserRepository fakeUserRepository = new FakeUserRepository();
        UserService service = new UserService(fakeUserRepository);

        //When
        Integer actualCountOfUsers = service.getCountOfUsers();

        //Then
        assertEquals(fakeUserRepository.allUsers.size(), actualCountOfUsers);
    }

    //WIth Captor
    @Test
    public void testSaveUsers() {
        //Given
        UserRepository mockUserRepository = mock(UserRepository.class);
        UserService service = new UserService(mockUserRepository);
        User user = new User(4L, "Vasya", "Pupkin");

        //When
        service.saveUser(user);

        //Then
        ArgumentCaptor<User> userCaptor=ArgumentCaptor.forClass(User.class);
        verify(mockUserRepository).save(userCaptor.capture());
        User actualUser=userCaptor.getValue();
        assertEquals(user, actualUser);
    }


}