package de.nordakademie.multiplechoice.answer.service;

import de.nordakademie.multiplechoice.answer.model.AnswerRepository;
import de.nordakademie.multiplechoice.answer.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Steven on 07.11.2017.
 */
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(final AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Transactional(readOnly = true)
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Transactional
    public void create(final Answer answer) {
        answerRepository.create(answer);
    }

}