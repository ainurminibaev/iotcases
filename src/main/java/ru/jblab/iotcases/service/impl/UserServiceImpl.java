package ru.jblab.iotcases.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jblab.iotcases.model.User;
import ru.jblab.iotcases.model.UserInfo;
import ru.jblab.iotcases.repository.UserInfoRepository;
import ru.jblab.iotcases.repository.UserRepository;
import ru.jblab.iotcases.service.UserService;

import java.util.List;

/**
 * Created by ainurminibaev on 26.08.14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    public User findUser(String login) {
        return userRepository.findOneByLogin(login);
    }

    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    @Override
    public List<UserInfo> getAllUserInfos() {
        return Lists.newArrayList(userInfoRepository.findAll());
    }


}
