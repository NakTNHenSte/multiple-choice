package de.nordakademie.multiplechoice.answer.model;

/**
 * Created by Steven on 08.11.2017.
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class AnswerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(final Answer answer) {
        entityManager.persist(answer);
    }

    public void delete(final Answer answer) {
        entityManager.remove(answer);
    }

    public void update(Answer answer) {
        entityManager.merge(answer);
    }

    public List<Answer> findAll(long questionId) {
        return entityManager.createQuery("SELECT r FROM Answer r WHERE question_Id = :questionId", Answer.class)
                .setParameter("questionId", questionId).getResultList();
    }
    public Answer findOne(final long answerID) {return entityManager.find(Answer.class, answerID);
    }
}

