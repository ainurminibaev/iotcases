package ru.jblab.iotcases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jblab.iotcases.model.UserInfo;

/**
 * Created by ainurminibaev on 27.10.15.
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
