package ru.kpfu.itis.util;

import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.Role;

/**
 * Created by vladislav on 14.11.15.
 */
public class UserFromToUser {
    public static User transformUser(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setPassword(userForm.getPassword());
        if (userForm.getRole() == 1) {
            user.setRole(Role.ROLE_ADMIN);
        } else if (userForm.getRole() == 0) {
            user.setRole(Role.ROLE_USER);
        }
        return user;
    }

    public static User update(User user, UserForm userForm) {
        user.setName(userForm.getName());
        user.setPassword(userForm.getPassword());
        if (userForm.getRole() == 1) {
            user.setRole(Role.ROLE_ADMIN);
        } else if (userForm.getRole() == 0) {
            user.setRole(Role.ROLE_USER);
        }
        return user;
    }


}
