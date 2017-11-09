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
}
