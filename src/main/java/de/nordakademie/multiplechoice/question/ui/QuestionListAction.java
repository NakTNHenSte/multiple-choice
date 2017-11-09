package de.nordakademie.multiplechoice.question.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by chris on 09.11.17.
 */

public class QuestionListAction implements Action {

    private final QuestionService questionService;
    private List<Question> questions;

    @Autowired
    public QuestionListAction(final QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public String execute() throws Exception {
        questions = questionService.findAll();
        return SUCCESS;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
