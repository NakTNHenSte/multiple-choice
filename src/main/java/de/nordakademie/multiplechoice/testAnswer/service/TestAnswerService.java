package de.nordakademie.multiplechoice.testAnswer.service;

import de.nordakademie.multiplechoice.answer.service.AnswerService;
import de.nordakademie.multiplechoice.exam.service.ExamService;
import de.nordakademie.multiplechoice.testAnswer.model.TestAnswer;
import de.nordakademie.multiplechoice.testAnswer.model.TestAnswerRepository;
import de.nordakademie.multiplechoice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TestAnswerService {
    private final TestAnswerRepository testAnswerRepository;
    private ExamService examService;
    private AnswerService answerService;
    private UserService userService;

    @Autowired
    public TestAnswerService(final TestAnswerRepository testAnswerRepository, final ExamService examService, AnswerService answerService, UserService userService) {
        this.testAnswerRepository = testAnswerRepository;
        this.examService = examService;
        this.answerService = answerService;
        this.userService = userService;
    }

    @Transactional(readOnly = true)
    public List<TestAnswer> findAll() {
        return testAnswerRepository.findAll();
    }

    @Transactional
    public TestAnswer findOne(final long testAnswerId){
        return testAnswerRepository.findOne(testAnswerId);
    }

    @Transactional
    public void create(final TestAnswer testAnswer, long examId, long userId, long answerId) {
        testAnswer.setExam(examService.findOne(examId));
        testAnswer.setAnswer(answerService.findOne(answerId));
        testAnswer.setUser(userService.find(userId));
        testAnswerRepository.create(testAnswer);
    }

    @Transactional
    public void delete(final long testAnswerId){
        final TestAnswer testAnswer = testAnswerRepository.findOne(testAnswerId);
        testAnswerRepository.delete(testAnswer);
    }

    @Transactional
    public void update(TestAnswer testAnswer) {
        testAnswerRepository.update(testAnswer);
    }
}

