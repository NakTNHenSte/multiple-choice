package de.nordakademie.multiplechoice.participation.model;

/**
 * Created by Daniel Fiolka on 23.11.17.
 */

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ParticipationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(final Participation participation) {
        entityManager.persist(participation);
    }

    public void delete(final Participation participation) {
        entityManager.remove(participation);
    }

    public void update(Participation participation) {
        entityManager.merge(participation);
    }

    public List<Participation> findAll(long examId) {
        return entityManager.createQuery("SELECT p FROM Participation p WHERE exam_Id = :examId", Participation.class)
                .setParameter("examId", examId).getResultList();
    }

    public Participation findOne(final long participationID) {return entityManager.find(Participation.class, participationID);
    }

    public Participation findByUserIdAndExamId(long userId, long examId) {
        return entityManager.createQuery("SELECT p FROM Participation p WHERE exam_id = :examId " +
                "AND user_id = :userId", Participation.class)
                .setParameter("examId", examId).setParameter("userId", userId).getSingleResult();
    }

    public List<Participation> findByUser(long userId) {
        return entityManager.createQuery("SELECT p FROM Participation p WHERE user_id = :userId", Participation.class)
                .setParameter("userId", userId).getResultList();
    }
}