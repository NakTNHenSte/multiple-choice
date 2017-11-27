package de.nordakademie.multiplechoice.question.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by chris on 08.11.17.
 */

@Repository
public class QuestionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Diese Methode erschafft eine neue question Entität in der Datenbank.
     *
     * @param question ist die zu erschaffende Entität.
     */
    public void create(final Question question) {
        entityManager.persist(question);
    }

    /**
     * Entfernt eine question aus der Datenbank.
     *
     * @param question ist das die zu entfernende Entität.
     */
    public void delete(final Question question) {
        entityManager.remove(question);
    }

    /**
     * @return eine Liste mit allen Question Entitäten aus der Datenbank.
     */
    public List<Question> findAll() {
        return entityManager.createQuery("SELECT q FROM Question q", Question.class).getResultList();
    }

    /**
     * Findet eine question aus der Datenbank anhand des Parameters.
     *
     * @param questionId ist die Id der question die gefunden werden soll.
     * @return gibt eine question zurück.
     */
    public Question findOne(final long questionId) {
        return entityManager.find(Question.class, questionId);
    }

    public List<Question> findByExam(long examId) {
        return entityManager.createQuery("SELECT q FROM Question q WHERE exam_id = :examId", Question.class)
                .setParameter("examId", examId).getResultList();
    }

    /**
     * Updated bzw. aktualisiert eine question in der Datenbank.
     * @param question ist die question mit den aktualisierten Attributen.
     */
    public void update(Question question) {
        entityManager.merge(question);
    }

}
