package ru.kpfu.itis.repository.impl;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public void saveUser(User user) {
        em.merge(user);
    }

    @Override
    public User searchUserById(Long id) {
        Query query = em.createNativeQuery("SELECT * FROM users u WHERE u.id = ?", User.class);
        query.setParameter(1, id);
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> getAllUser() {
        Query query = em.createNativeQuery("SELECT * FROM users", User.class);
        return ((List<User>) query.getResultList());
    }

    @Override
    public User updateUserApi(User user) {
        return em.merge(user);
    }

    public void updateUser(User user) {
        em.persist(user);
    }

    @Override
    public void setAccess(User user) {

    }

    @Override
    public void deleteAccess(User user) {

    }
}
