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

    /**
     * Diese Methode erschafft eine neue participation Entität in der Datenbank.
     *
     * @param participation ist die zu erschaffende Entität.
     */
    public void create(final Participation participation) {
        entityManager.persist(participation);
    }

    /**
     * Entfernt eine participation aus der Datenbank.
     *
     * @param participation ist die zu entfernende participation.
     */
    public void delete(final Participation participation) {
        entityManager.remove(participation);
    }

    /**
     * Updated bzw. aktualisiert eine participation in der Datenbank.
     * @param participation ist die participation mit den aktualisierten Attributen.
     */
    public void update(Participation participation) {
        entityManager.merge(participation);
    }

    /**
     * @return Eine Liste mit allen participation Entitäten aus der Datenbank, die zu
     * einem bestimmten Examen gehören.
     * @param examId die Id des Exams.
     */
    public List<Participation> findAll(long examId) {
        return entityManager.createQuery("SELECT p FROM Participation p WHERE exam_Id = :examId", Participation.class)
                .setParameter("examId", examId).getResultList();
    }

    /**
     * Findet eine participation aus der Datenbank anhand des Parameters.
     *
     * @param participationID die Id der participation die gefunden werden soll.
     * @return gibt eine participation zurück.
     */
    public Participation findOne(final long participationID) {return entityManager.find(Participation.class, participationID);
    }

    /**
     * Findet eine participation aus der Datenbank anhand der Parameter.
     *
     * @param userId die Id des users zu dem participations gefunden werden sollen.
     * @param examId die Id des exams zu dem participations gefunden werden sollen.
     * @return gibt eine participation zurück.
     */
    public Participation findByUserIdAndExamId(long userId, long examId) {

        return entityManager.createQuery("SELECT p FROM Participation p WHERE exam_id = :examId " +
                "AND user_id = :userId", Participation.class)
                .setParameter("examId", examId).setParameter("userId", userId).getSingleResult();
    }

    /**
     * Findet mehrere participations aus der Datenbank anhand des Parameters.
     *
     * @param userId die Id des users zu dem participations gefunden werden sollen.
     * @return gibt eine Liste von participations zurück.
     */
    public List<Participation> findByUser(long userId) {
        return entityManager.createQuery("SELECT p FROM Participation p WHERE user_id = :userId", Participation.class)
                .setParameter("userId", userId).getResultList();
    }
}