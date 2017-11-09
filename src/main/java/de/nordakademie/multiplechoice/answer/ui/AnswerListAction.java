package de.nordakademie.multiplechoice.answer.ui;

/**
 * Created by Steven on 09.11.2017.
 */
import de.nordakademie.multiplechoice.answer.service.AnswerService;
import de.nordakademie.multiplechoice.answer.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Action;

import java.util.List;

public class AnswerListAction implements Action {


    private final AnswerService answerService;

    private List<Answer> answers;

    @Autowired
    public AnswerListAction(final AnswerService answerService) {
        this.answerService = answerService;
    }

    @Override
    public String execute() {
        answers = answerService.findAll();
        return SUCCESS;
    }

    public List<Answer> getExams() {
        return answers;
    }

}