package ru.kpfu.itis.service;

import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.helper.ChangingUser;

import java.util.List;


public interface UserService {

    void saveUser(UserForm userForm);

    void updateUser(UserForm userForm);

    User updateUser(ChangingUser changingUser);

    void setAccess(User user);

    void deleteAccess(User user);

    User searchUserById(Long id);

    List<User> getAllUser();

    User checkPin(String pin);
}
