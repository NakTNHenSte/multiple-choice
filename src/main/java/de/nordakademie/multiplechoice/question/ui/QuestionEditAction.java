package de.nordakademie.multiplechoice.question.ui;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chris on 18.11.17.
 */
public class QuestionEditAction extends ActionSupport {

    private final QuestionService questionService;

    private Question question;

    @Autowired
    public QuestionEditAction(final QuestionService questionService) {
        this.questionService = questionService;
    }

    public String getForm() { return SUCCESS; }

    public String saveQuestion() {
        questionService.create(question);
        return SUCCESS;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(final Question question) {
        this.question = question;
    }



}
