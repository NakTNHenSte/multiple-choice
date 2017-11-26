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

    @Transactional(readOnly = true)
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Transactional
    public Question findOne(final long questionId){
        return questionRepository.findOne(questionId);
    }

    @Transactional
    public void create(final Question question, long examId) {
        question.setExam(examService.findOne(examId));
        questionRepository.create(question);
    }

    @Transactional(readOnly = true)
    public List<Question> findByExam(long examId) {
        return questionRepository.findByExam(examId);
    }

    @Transactional
    public void delete(final long questionId){
        final Question question = questionRepository.findOne(questionId);
        questionRepository.delete(question);
    }

    @Transactional
    public void update(Question question) {
        questionRepository.update(question);
    }
}
