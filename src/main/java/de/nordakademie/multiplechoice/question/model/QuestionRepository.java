package de.nordakademie.multiplechoice.question.model;

import de.nordakademie.multiplechoice.user.model.User;
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

    public void create(final Question question) {
        entityManager.persist(question);
    }

    public void delete(final Question question) {
        entityManager.remove(question);
    }

    public List<Question> findAll() {
        return entityManager.createQuery("SELECT q FROM Question q", Question.class).getResultList();
    }

    public Question findOne(final long questionId) {
        return entityManager.find(Question.class, questionId);
    }

    public List<Question> findByExam(long examId) {
        return entityManager.createQuery("SELECT q FROM Question q WHERE exam_id = :examId", Question.class)
                .setParameter("examId", examId).getResultList();
    }
}
