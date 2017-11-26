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

    /**
     * Diese Methode erschafft eine neue User Entität in der Datenbank.
     * @param user ist die zu erschaffende Entität.
     */
    public void create(final User user) {
        entityManager.persist(user);
    }

    /**
     * @return alle User Entitäten aus der Datenbank.
     */
    public List<User> findAll() {
        return entityManager.createQuery("SELECT r FROM User r", User.class).getResultList();
    }

    /**
     * Findet einen User anhand des Parameters.
     * @param userNaturalId der username des Users.
     * @return gibt einen User zurück.
     */
    public User findUser(final String userNaturalId) {
        try {
            return entityManager.createQuery("SELECT r FROM User r WHERE username = :username", User.class)
                    .setParameter("username", userNaturalId).getSingleResult();
        } catch (final NoResultException e) {
            return null;
        }
    }

    /**
     * Findet einen User aus der Datenbank anhand des Parameters.
     * @param userId die Id des Users der gefunden werden soll.
     * @return gibt einen User zurück.
     */
    public User find(long userId) {
        return entityManager.find(User.class, userId);
    }


    /**
     * @return gibt alle User vom Typ Studenten zurück.
     */
    public List<User> findStudents() {

        try {
            return entityManager.createQuery("SELECT r FROM User r WHERE type = :type", User.class).
                    setParameter("type", "S").getResultList();
        } catch (final NoResultException e) {
            return null;
        }
    }
}
