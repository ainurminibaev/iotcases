package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.model.SecList;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.Role;
import ru.kpfu.itis.model.helper.ChangingUser;
import ru.kpfu.itis.repository.SecListRepository;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.SecListUtil;
import ru.kpfu.itis.util.UserFromToUser;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SecListRepository secListRepository;

    @Override
    public void saveUser(UserForm userForm) {
        User user = UserFromToUser.transformUser(userForm);
        userRepository.saveUser(user);
        List<SecList> secLists = SecListUtil.transformToList(user.getId(), userForm.getDevice());
        secListRepository.save(secLists);
    }

    @Override
    public void updateUser(UserForm userForm) {

    }

    @Override
    public User checkPin(String pin) {
        Long id = Long.parseLong(pin.substring(0, 3));
        User user = userRepository.searchUserById(id);
        if (user == null) {
            return null;
        }
        String pass = pin.substring(3);
        if (!pass.equals(user.getPassword())) {
            return null;
        }
        return user;
    }

    @Override
    public User updateUser(ChangingUser changingUser) {
        User user = checkPin(changingUser.getPin());
        if (user == null) {
            return null;
        }
        if (!"".equals(changingUser.getName())) {
            user.setName(changingUser.getName());
        }
        if (!"".equals(changingUser.getPassword())) {
            user.setPassword(changingUser.getPassword());
        }
        return userRepository.updateUser(user);
    }

    @Override
    public void setAccess(User user) {

    }

    @Override
    public void deleteAccess(User user) {

    }

    @Override
    public User searchUserById(Long id) {
        return userRepository.searchUserById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }
}
