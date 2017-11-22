package de.nordakademie.multiplechoice.user.service;

import de.nordakademie.multiplechoice.user.model.User;
import de.nordakademie.multiplechoice.user.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dieke Luebberstedt on 07.11.17.
 */

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) { this.userRepository = userRepository; }

    @Transactional(readOnly = true)
    public List<User> findAll() { return userRepository.findAll(); }

    @Transactional
    public void create(final User user) { userRepository.create(user); }

    @Transactional(readOnly = true)
    public User findUser(final String username) {
        return userRepository.findUser(username);
    }

    @Transactional(readOnly = true)
    public User find(final long userId) {
        return userRepository.find(userId);
    }

}
