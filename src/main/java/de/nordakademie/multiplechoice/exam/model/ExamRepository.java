package de.nordakademie.multiplechoice.exam.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Daniel Fiolka on 08.11.17.
 */

@Repository
public class ExamRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Diese Methode erschafft eine neue Exam Entität in der Datenbank.
     * @param exam ist die zu erschaffende Exam Entität.
     */
    public void create(final Exam exam) {
        entityManager.persist(exam);
    }

    /**
     * @return alle Exam Entitäten aus der Datenbank.
     */
    public List<Exam> findAll() {
        return entityManager.createQuery("SELECT r FROM Exam r", Exam.class).getResultList();
    }

    /**
     * Findet ein Exam aus der Datenbank anhand des Parameters.
     * @param examId die Id des Exams das gefunden werden sollen.
     * @return gibt ein Exam zurück.
     */
    public Exam findOne(final long examId) {
        return entityManager.find(Exam.class, examId);
    }

    /**
     * Entfernt ein Exam aus der Datenbank.
     * @param exam ist das zu entfernende Exam.
     */
    public void remove(Exam exam) {
        entityManager.remove(exam);
    }

    /**
     * Updated bzw. aktualisiert ein Exam in der Datenbank.
     * @param exam ist das Exam mit den aktualisierten Werten.
     */
    public void update(Exam exam) {
        entityManager.merge(exam);
    }

    /**
     * Findet Exams anhand einer userId.
     * @param userId die Id eines Users zu der die Exams gefunden werden sollen.
     * @return gibt eine Liste von Exams zurück.
     */
    public List<Exam> findByUser(long userId) {
        return entityManager.createQuery("SELECT q FROM Exam q WHERE user_id = :userId", Exam.class)
                .setParameter("userId", userId).getResultList();
    }
}
