package de.nordakademie.multiplechoice.exam.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by chris on 08.11.17.
 */

@Repository
public class ExamRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ExamRepository() {
    }

    public Exam findOne(final long examId) {
        return entityManager.find(Exam.class, examId);
    }

}
