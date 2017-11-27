package de.nordakademie.multiplechoice.question.service;

import de.nordakademie.multiplechoice.exam.service.ExamService;
import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.question.model.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chris on 07.11.17.
 */

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private ExamService examService;

    @Autowired
    public QuestionService(final QuestionRepository questionRepository, final ExamService examService) {
        this.questionRepository = questionRepository;
        this.examService = examService;
    }

    /**
     * @return Eine Liste mit allen question Entitäten aus der Datenbank.
     */
    @Transactional(readOnly = true)
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    /**
     * Ruft das QuestionRepository auf um eine Question aus der Datenbank zu finden.
     * @param questionId ist die Id der zu findenden Question.
     */
    @Transactional
    public Question findOne(final long questionId){
        return questionRepository.findOne(questionId);
    }

    /**
     * Diese Methode übergibt dem QuestionRepository eine Question um diese
     * in der Datenbank zu persistieren.
     * @param question ist die zu erschaffende question Entität.
     */
    @Transactional
    public void create(final Question question, long examId) {
        question.setExam(examService.findOne(examId));
        questionRepository.create(question);
    }

    /**
     * Ruft das QuestionRepository auf um Questions, die zu einem bestimmten Exam gehören zurückzugeben.
     * @param examId die Id des Exams.
     * @return eine Liste von Questions.
     */
    @Transactional(readOnly = true)
    public List<Question> findByExam(long examId) {
        return questionRepository.findByExam(examId);
    }

    /**
     * Ruft das QuestionRepository auf um eine Question aus der Datenbank zu löschen.
     * @param questionId ist die Id der zu entfernenden question.
     */
    @Transactional
    public void delete(final long questionId){
        final Question question = questionRepository.findOne(questionId);
        questionRepository.delete(question);
    }

    /**
     * Ruft das QuestionRepository auf um eine Question in der Datenbank zu aktualisieren.
     * @param question ist die Question mit den zu aktualisierenden Werten.
     */
    @Transactional
    public void update(Question question) {
        questionRepository.update(question);
    }
}
