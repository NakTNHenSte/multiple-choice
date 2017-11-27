package de.nordakademie.multiplechoice.answer.service;

import de.nordakademie.multiplechoice.answer.model.AnswerRepository;
import de.nordakademie.multiplechoice.answer.model.Answer;
import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.question.model.QuestionRepository;
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
    private final QuestionRepository questionRepository;

    @Autowired
    public AnswerService(final AnswerRepository answerRepository, final QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }


    /** Ruft das AnswerRepository auf um alle Answer Entitäten zurückzugeben,
     * die zur übergebenen questionId gehören.
     * @param questionId die questionId zu der answers gesucht werden sollen.
     * @return eine Liste von answers.
     */
    @Transactional(readOnly = true)
    public List<Answer> findAll(long questionId) {
        return answerRepository.findAll(questionId);
    }

    /**
     * Diese Methode übergibt dem AnswerRepository eine Answer um diese
     * in der Datenbank zu persistieren.
     * @param answer ist die zu erschaffende answer Entität.
     */
    @Transactional
    public void create(final Answer answer) {
        final Question question = questionRepository.findOne(answer.getQuestion().getId());
        answer.setQuestion(question);
        answerRepository.create(answer);
    }

    /**
     * Ruft das AnswerRepository auf um eine Answer aus der Datenbank zu löschen.
     * @param answerID ist die Id der zu entfernenden answer.
     */
    @Transactional
    public void delete(final long answerID) {
        final Answer answer = answerRepository.findOne(answerID);
        answerRepository.delete(answer);
    }

    /**
     * Ruft das AnswerRepository auf um eine Answer aus der Datenbank zu löschen.
     * @param answerID ist die Id der zu entfernenden Answer.
     */
    @Transactional
    public Answer findOne(final long answerID){
        final Answer answer = answerRepository.findOne(answerID);
        return answer;
    }

    /**
     * Ruft das AnswerRepository auf um eine Answer in der Datenbank zu aktualisieren.
     * @param answer ist die Answer mit den zu aktualisierenden Werten.
     */
    @Transactional
    public void update(Answer answer) {
        answerRepository.update(answer);
    }
}