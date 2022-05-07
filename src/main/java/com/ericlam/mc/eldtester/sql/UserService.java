package com.ericlam.mc.eldtester.sql;

import java.util.Optional;

public interface UserService {

    void save(User user);

    void saveOrUpdate(User user);

    Optional<User> findByUsername(String username);

    Iterable<User> findAll();

    void deleteById(String username);

    boolean existByUsername(String username);
}
