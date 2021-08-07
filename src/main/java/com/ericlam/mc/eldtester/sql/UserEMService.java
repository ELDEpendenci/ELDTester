package com.ericlam.mc.eldtester.sql;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.Optional;


public class UserEMService implements UserService {


    @Inject
    private Provider<EntityManager> entityManagerProvider;


    @Override
    public void save(User user) {
        EntityManager entityManager = entityManagerProvider.get();
        entityManager.getTransaction().begin(); // 打開連接
        entityManager.persist(user); // 儲存方法
        entityManager.getTransaction().commit(); // 關閉連接並提交
    }

    @Override
    public Optional<User> findByUsername(String username) {
        EntityManager entityManager = entityManagerProvider.get();
        return Optional.ofNullable(entityManager.find(User.class, username)); // 使用 primary key 搜索
    }


    @Override
    public Iterable<User> findAll() {
        EntityManager entityManager = entityManagerProvider.get();
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void deleteById(String username) {
        EntityManager entityManager = entityManagerProvider.get();
        entityManager.getTransaction().begin(); // 打開連接
        entityManager.remove(entityManager.getReference(User.class, username));
        entityManager.getTransaction().commit(); // 關閉連接並提交
    }

    @Override
    public boolean existByUsername(String username) {
        return false;
    }


}
