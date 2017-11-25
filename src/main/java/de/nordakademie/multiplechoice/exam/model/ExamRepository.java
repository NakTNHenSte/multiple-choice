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

    public void create(final Exam exam) {
        entityManager.persist(exam);
    }

    public List<Exam> findAll() {
        return entityManager.createQuery("SELECT r FROM Exam r", Exam.class).getResultList();
    }

    public Exam findOne(final long examId) {
        return entityManager.find(Exam.class, examId);
    }

    public void remove(Exam exam) {
        entityManager.remove(exam);
    }

    public void update(Exam exam) {
        entityManager.merge(exam);
    }

    public List<Exam> findByUser(long userId) {
        return entityManager.createQuery("SELECT q FROM Exam q WHERE user_id = :userId", Exam.class)
                .setParameter("userId", userId).getResultList();
    }
}
