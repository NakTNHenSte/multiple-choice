package de.nordakademie.multiplechoice.testAnswer.service;

import de.nordakademie.multiplechoice.answer.model.Answer;
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
    public TestAnswer findOne(final long testAnswerId) {
        return testAnswerRepository.findOne(testAnswerId);
    }

    @Transactional
    public TestAnswer findByAnswerId(final long answerId) {
        return testAnswerRepository.findByAnswerId(answerId);
    }


    @Transactional
    public void create(String answerFromUser, long examId, long userId, long answerId) {

        TestAnswer testAnswerFromDatabase = testAnswerRepository.findByUserIdAndExamIdAndAnswerId(examId, userId, answerId);
        TestAnswer testAnswer = prepareTestAnswer(answerFromUser, examId, userId, answerId);
        if (testAnswerFromDatabase == null) {
            testAnswerRepository.create(testAnswer);
        } else {
            testAnswer.setId(testAnswerFromDatabase.getId());
            testAnswerRepository.update(testAnswer);
        }
    }

    private TestAnswer prepareTestAnswer(String answerFromUser, long examId, long userId, long answerId) {
        Answer answerFromDatabase = answerService.findOne(answerId);

        TestAnswer testAnswer = new TestAnswer();
        testAnswer.setStudentAnswer(answerFromUser);
        testAnswer.setExam(examService.findOne(examId));
        testAnswer.setAnswer(answerFromDatabase);
        testAnswer.setUser(userService.find(userId));

        if (answerFromDatabase.getTrueOrFalse().equals(answerFromUser)) {
            testAnswer.setCorrectness(true);
        } else {
            testAnswer.setCorrectness(false);
        }
        return testAnswer;
    }

    @Transactional
    public void delete(final long testAnswerId) {
        final TestAnswer testAnswer = testAnswerRepository.findOne(testAnswerId);
        testAnswerRepository.delete(testAnswer);
    }

    @Transactional
    public void update(TestAnswer testAnswer) {
        testAnswerRepository.update(testAnswer);
    }
}
