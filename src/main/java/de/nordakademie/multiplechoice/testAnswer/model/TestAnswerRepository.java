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

    public TestAnswer findByUserIdAndExamIdAndAnswerId(long userId, long examId, long answerId) {
        try {
            return entityManager.createQuery("SELECT p FROM TestAnswer p WHERE exam_id = :examId " +
                    "AND user_id = :userId AND answer_answerID = :answerId", TestAnswer.class)
                    .setParameter("examId", examId).setParameter("userId", userId).setParameter("answerId", answerId).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public void update(TestAnswer testAnswer) {
        entityManager.merge(testAnswer);
    }

    public TestAnswer findByAnswerId(long answerId) {
        try {
            return entityManager.createQuery("SELECT p FROM TestAnswer p WHERE answer_answerID = :answerId", TestAnswer.class)
                    .setParameter("answerId", answerId).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public void deleteAllByExam(long examId) {
         entityManager.createQuery("DELETE FROM TestAnswer WHERE examId = :examId")
                .setParameter("examId", examId);
    }
}
