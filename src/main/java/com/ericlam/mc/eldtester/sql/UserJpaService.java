package com.ericlam.mc.eldtester.sql;

import javax.inject.Inject;
import java.util.Optional;

public class UserJpaService implements UserService {


    @Inject
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findById(username);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public boolean existByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }


}
