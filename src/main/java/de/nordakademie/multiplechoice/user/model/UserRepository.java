package de.nordakademie.multiplechoice.user.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Dieke Luebberstedt on 09.11.17.
 */

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(final User user) {
        entityManager.persist(user);
    }

    public List<User> findAll() {
        return entityManager.createQuery("SELECT r FROM User r", User.class).getResultList();
    }

    public User findUser(final String userNaturalId) {
        try {
            return entityManager.createQuery("SELECT r FROM User r WHERE username = :username", User.class)
                    .setParameter("username", userNaturalId).getSingleResult();
        } catch (final NoResultException e) {
            return null;
        }
    }

    public User find(long userId) {
        return entityManager.find(User.class, userId);
    }

    public List<User> findStudents() {

        try {
            return entityManager.createQuery("SELECT r FROM User r WHERE type = :type", User.class).
                    setParameter("type", "S").getResultList();
        } catch (final NoResultException e) {
            return null;
        }
    }
}
