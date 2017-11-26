package de.nordakademie.multiplechoice.testAnswer.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.multiplechoice.answer.model.Answer;
import de.nordakademie.multiplechoice.answer.service.AnswerService;
import de.nordakademie.multiplechoice.testAnswer.service.TestAnswerService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestAnswerAction extends ActionSupport implements SessionAware {


    private long examId;
    private long answerId;
    private long questionId;
    private List<String> givenAnswers = new ArrayList<>();
    private int currentQuestionIndex;
    private TestAnswerService testAnswerService;
    private Map<String, Object> sessionMap;
    private AnswerService answerService;


    @Autowired
    public TestAnswerAction(TestAnswerService testAnswerService, AnswerService answerService) {
        this.testAnswerService = testAnswerService;
        this.answerService = answerService;
    }

    public String saveTestAnswers() {


        for (int i = 0; i < givenAnswers.size(); i++) {
            Answer answerFromDatabase = answerService.findAll(questionId).get(i);
            testAnswerService.create(givenAnswers.get(i), examId, (long) sessionMap.get("userId"), answerFromDatabase.getAnswerID());
        }

        return SUCCESS;
    }


    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public List<String> getGivenAnswers() {
        return givenAnswers;
    }

    public void setGivenAnswers(List<String> givenAnswers) {
        this.givenAnswers = givenAnswers;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}
