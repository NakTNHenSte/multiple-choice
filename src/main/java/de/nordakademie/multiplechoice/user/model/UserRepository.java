package de.nordakademie.multiplechoice.user.model;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Dieke on 09.11.17.
 */

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(final User user)  {
        entityManager.persist(user);
    }

    public List<User> findAll() {
        return entityManager.createQuery("SELECT r FROM User r", User.class).getResultList();
    }

}
