package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Device;
import ru.kpfu.itis.model.SecList;
import ru.kpfu.itis.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SecListRepository extends JpaRepository<SecList, Long> {

    @Query("select d from Device d where d.id in (select sl.deviceId from SecList sl where sl.userId = ?1)")
    List<Device> getDevicesByUserId(Long uid);

    @Query("select d from Device d where d.id = ?1")
    Device getDevice(Long id);

    @Query("select u from User u where u.id in (select sl.userId from SecList sl where sl.deviceId = ?1)")
    List<User> getDeviceUsers(Long id);

    @Query("select u.id from User u where u.id in (select sl.userId from SecList sl where sl.deviceId = ?1)")
    List<Long> getDeviceUsersId(Long id);

    @Transactional
    @Modifying
    @Query("delete from SecList p where p.userId = ?1")
    void delete(Long id);

}