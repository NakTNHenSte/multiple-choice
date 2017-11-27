package de.nordakademie.multiplechoice.answer.model;



import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Steven on 08.11.2017.
 * Das zur Entität Answer zugehörige Repository.
 */
@Repository
public class AnswerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Diese Methode erschafft eine neue answer Entität in der Datenbank.
     *
     * @param answer ist die zu erschaffende Entität.
     */
    public void create(final Answer answer) {
        entityManager.persist(answer);
    }


    /**
     * Entfernt eine Answer aus der Datenbank.
     *
     * @param answer ist die zu entfernende Answer.
     */
    public void delete(final Answer answer) {
        entityManager.remove(answer);
    }


    /**
     * Updated bzw. aktualisiert eine answer in der Datenbank.
     * @param answer ist die answer mit den aktualisierten Attributen.
     */
    public void update(Answer answer) {
        entityManager.merge(answer);
    }

    /**
     * Gibt Answer Entitäten zurück, die zu einer bestimmten Question gehören.
     * @param questionId die Id der Question
     * @return Eine Liste mit allen answer Entitäten aus der Datenbank.
     */
    public List<Answer> findAll(long questionId) {
        return entityManager.createQuery("SELECT r FROM Answer r WHERE question_Id = :questionId", Answer.class)
                .setParameter("questionId", questionId).getResultList();
    }

    /**
     * Findet eine answer aus der Datenbank anhand des Parameters.
     *
     * @param answerID die Id der answer die gefunden werden soll.
     * @return gibt eine answer zurück.
     */
    public Answer findOne(final long answerID) {
        return entityManager.find(Answer.class, answerID);
    }
}

