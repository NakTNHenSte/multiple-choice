package de.nordakademie.multiplechoice.question.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.multiplechoice.answer.model.Answer;
import de.nordakademie.multiplechoice.answer.service.AnswerService;
import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 18.11.17.
 */
public class QuestionEditAction extends ActionSupport {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private Question question;

    private List<Answer> answerList = new ArrayList<Answer>();
    private int answerCount;
    private Answer answer;


    @Autowired
    public QuestionEditAction(final QuestionService questionService, final AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;

        //TODO: spaeter rausnehmen
        this.answerCount = 3;
    }

    public String getForm() { return SUCCESS; }

    public String saveQuestion() {

        questionService.create(question);

        for (Answer answer : answerList) {
            answer.setQuestion(question);
            answerService.create(answer);
        }
        return SUCCESS;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(final Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }



}
