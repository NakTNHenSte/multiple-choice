package de.nordakademie.multiplechoice.testAnswer.model;

import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TestAnswerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(final TestAnswer testAnswer) {
        entityManager.persist(testAnswer);
    }

    public void delete(final TestAnswer testAnswer) {
        entityManager.remove(testAnswer);
    }

    public List<TestAnswer> findAll() {
        return entityManager.createQuery("SELECT q FROM TestAnswer q", TestAnswer.class).getResultList();
    }

    public TestAnswer findOne(final long testAnswerId) {
        return entityManager.find(TestAnswer.class, testAnswerId);
    }

    public List<TestAnswer> findByUser(long userId) {
        return entityManager.createQuery("SELECT p FROM TestAnswer p WHERE user_id = :userId", TestAnswer.class)
                .setParameter("userId", userId).getResultList();
    }

    public List<TestAnswer> findByUserIdAndExamId(long userId, long examId) {
        return entityManager.createQuery("SELECT p FROM TestAnswer p WHERE exam_id = :examId " +
                "AND user_id = :userId", TestAnswer.class)
                .setParameter("examId", examId).setParameter("userId", userId).getResultList();
    }

    public void update(TestAnswer testAnswer) {
        entityManager.merge(testAnswer);
    }

}
