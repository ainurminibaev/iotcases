package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.model.SecList;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.Role;
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
    public void setAccess(User user) {

    }

    @Override
    public void deleteAccess(User user) {

    }
}
