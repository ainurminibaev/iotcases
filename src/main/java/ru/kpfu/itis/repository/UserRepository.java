package ru.kpfu.itis.repository;


import ru.kpfu.itis.model.User;

import java.util.List;

public interface UserRepository {

    User saveUser(User user);

    User updateUserApi(User user);

    void updateUser(User user);

    void setAccess(User user);

    void deleteAccess(User user);

    User searchUserById(Long id);

    List<User> getAllUser();
}
