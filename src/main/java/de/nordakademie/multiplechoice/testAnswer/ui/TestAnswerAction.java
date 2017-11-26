package de.nordakademie.multiplechoice.testAnswer.ui;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TestAnswerAction extends ActionSupport {


    private long examId;
    private long userId;
    private long answerId;
    private List<String> givenAnswers = new ArrayList<>();
    private int currentQuestionIndex;

    @Autowired
    public TestAnswerAction() {
    }

    public String saveTestAnswers() {


        for (String answer : givenAnswers) {

        }

        return SUCCESS;
    }


    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
}
