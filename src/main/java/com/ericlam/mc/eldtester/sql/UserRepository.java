package com.ericlam.mc.eldtester.sql;

import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, String>, CustomARepo, CustomBRepo {

    boolean existsUserByUsername(String username);


}
