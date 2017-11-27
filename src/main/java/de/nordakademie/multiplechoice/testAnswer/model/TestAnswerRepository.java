package de.nordakademie.multiplechoice.testAnswer.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TestAnswerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Diese Methode erschafft eine neue testAnswer Entität in der Datenbank.
     *
     * @param testAnswer ist die zu erschaffende Entität.
     */
    public void create(final TestAnswer testAnswer) {
        entityManager.persist(testAnswer);
    }

    /**
     * Entfernt eine testAnswer aus der Datenbank.
     *
     * @param testAnswer ist die zu entfernende testAnswer.
     */
    public void delete(final TestAnswer testAnswer) {
        entityManager.remove(testAnswer);
    }

    /**
     * @return Eine Liste mit allen TestAnswer Entitäten aus der Datenbank.
     */
    public List<TestAnswer> findAll() {
        return entityManager.createQuery("SELECT q FROM TestAnswer q", TestAnswer.class).getResultList();
    }

    /**
     * Findet eine testAnswer aus der Datenbank anhand des Parameters.
     *
     * @param testAnswerId die Id der testAnswer die gefunden werden soll.
     * @return gibt eine testAnswer zurück.
     */
    public TestAnswer findOne(final long testAnswerId) {
        return entityManager.find(TestAnswer.class, testAnswerId);
    }

    /**
     * Findet eine bestimmte TestAnswer Entität anhand der Parameter.
     * @param userId die id des users, zu dem die testAnswer gehört.
     * @param examId die id des exams, zu dem die testAnswer gehört.
     * @param answerId die id der answer, zu dem die testAnswer gehört.
     * @return ist die gefundene TestAnswer
     */
    public TestAnswer findByUserIdAndExamIdAndAnswerId(long userId, long examId, long answerId) {
        try {
            return entityManager.createQuery("SELECT p FROM TestAnswer p WHERE exam_id = :examId " +
                    "AND user_id = :userId AND answer_answerID = :answerId", TestAnswer.class)
                    .setParameter("examId", examId).setParameter("userId", userId).setParameter("answerId", answerId).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    /**
     * Updated bzw. aktualisiert eine testAnswer in der Datenbank.
     * @param testAnswer ist die testAnswer mit den aktualisierten Attributen.
     */
    public void update(TestAnswer testAnswer) {
        entityManager.merge(testAnswer);
    }

    /**
     * Findet eine testAnswer aus der Datenbank anhand des Parameters.
     *
     * @param answerId die Id der answer zu dem testAnswer gehört.
     * @return gibt eine testAnswer zurück.
     */
    public TestAnswer findByAnswerId(long answerId) {
        try {
            return entityManager.createQuery("SELECT p FROM TestAnswer p WHERE answer_answerID = :answerId", TestAnswer.class)
                    .setParameter("answerId", answerId).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    /**
     * Löscht alle TestAnswers die zu einem bestimmten exam gehören.
     * @param examId die Id des bestimmten exams.
     */
    public void deleteAllByExam(long examId) {
         entityManager.createQuery("DELETE FROM TestAnswer WHERE examId = :examId")
                .setParameter("examId", examId);
    }
}
