package com.ericlam.mc.eldtester.sql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>, CustomARepo, CustomBRepo {

    boolean existsUserByUsername(String username);

}
