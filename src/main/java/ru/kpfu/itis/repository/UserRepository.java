package ru.kpfu.itis.repository;


import ru.kpfu.itis.model.User;

public interface UserRepository {

    void saveUser(User user);

    void updateUser(User user);

    void setAccess(User user);

    void deleteAccess(User user);
}
