package ru.kpfu.itis.service;

import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.model.User;

/**
 * Created by vladislav on 14.11.15.
 */
public interface UserService {

    void saveUser(UserForm userForm);

    void updateUser(UserForm userForm);

    void setAccess(User user);

    void deleteAccess(User user);

}