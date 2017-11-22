package de.nordakademie.multiplechoice.answer.model;

/**
 * Created by Steven on 08.11.2017.
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.nordakademie.multiplechoice.question.model.Question;
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

    public List<Answer> findAll() {
        return entityManager.createQuery("SELECT r FROM Answer r", Answer.class).getResultList();
    }

    public Answer findOne(final long answerID) {return entityManager.find(Answer.class, answerID);
    }
}

