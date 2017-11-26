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

    /**
     * Ruft das UserRepository auf um alle User Entitäten aus der Datenbank zurückzugeben.
     * @return alle User Entitäten aus der Datenbank.
     */
    @Transactional(readOnly = true)
    public List<User> findAll() { return userRepository.findAll(); }

    /**
     * Diese Methode übergibt dem UserRepository ein User um diesen
     * in der Datenbank zu persistieren.
     * @param user ist die zu persistierende User Entität.
     */
    @Transactional
    public void create(final User user) { userRepository.create(user); }

    /**
     * Ruft das UserRepository auf um anhand des usernames einen User zurückzugeben.
     * @param username der username des Users.
     * @return gibt einen User zurück.
     */
    @Transactional(readOnly = true)
    public User findUser(final String username) {
        return userRepository.findUser(username);
    }

    /**
     * Ruft das UserRepository auf um einen User anhand einer userId zu finden.
     * @param userId die Id des Users der gefunden werden soll.
     * @return gibt einen User zurück.
     */
    @Transactional(readOnly = true)
    public User find(final long userId) {
        return userRepository.find(userId);
    }

    /**
     * Ruft das UserRepository auf um alle User vom Typ Student zurückzugeben.
     * @return gibt alle User vom Typ Studenten zurück.
     */
    @Transactional(readOnly = true)
    public List<User> findStudents() {
        return userRepository.findStudents();
    }
}
