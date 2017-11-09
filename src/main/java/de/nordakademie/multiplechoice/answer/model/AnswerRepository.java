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

    public List<Answer> findAll(long questionID) {
        return entityManager.createQuery("SELECT a FROM Answer a WHERE a.questionID = :questionID ", Answer.class).setParameter("questionID", questionID).getResultList();
    }
}

