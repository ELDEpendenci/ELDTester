package com.ericlam.mc.eldtester.sql;

import chu77.eldependenci.sql.JpaFactoryService;
import chu77.eldependenci.sql.SQLService;
import com.ericlam.mc.eldtester.ELDTester;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import javax.inject.Inject;
import java.util.Optional;


public class UserService {

    private final UserRepository userRepository;

    @Inject
    public UserService(JpaFactoryService jpaFactoryService, SQLService sqlService) {
        JpaRepositoryFactory factory = jpaFactoryService.getJpaFactory(ELDTester.MY_TAG);
        this.userRepository = factory.getRepository(UserRepository.class);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findById(username);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }


}
