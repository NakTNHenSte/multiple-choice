package de.nordakademie.multiplechoice.question.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.multiplechoice.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chris on 19.11.17.
 */
public class QuestionAddAnswerAction extends ActionSupport {

    private final QuestionService questionService;

    @Autowired
    public QuestionAddAnswerAction(QuestionService questionService) {
        this.questionService = questionService;
    }

    public String addAnswer() {
        return "ADD_ANSWER";
    }



}
