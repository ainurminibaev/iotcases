package ru.jblab.iotcases.service;

import ru.jblab.iotcases.model.User;
import ru.jblab.iotcases.model.UserInfo;

import java.util.List;

/**
 * Created by ainurminibaev on 26.08.14.
 */
public interface UserService {

    User findUser(String login);

    User findOne(Long id);

    void save(UserInfo userInfo);

    List<UserInfo> getAllUserInfos();
}
