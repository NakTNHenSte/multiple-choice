package de.nordakademie.multiplechoice.answer.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.multiplechoice.answer.model.Answer;
import de.nordakademie.multiplechoice.answer.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Steven on 22.11.2017.
 */
public class AnswerDetailAction implements Action {


    private final AnswerService answerService;

    private Answer answer;

    private long answerID;

    @Autowired
    public AnswerDetailAction(final AnswerService answerService) {
        this.answerService = answerService;
    }

    @Override
    public String execute() {
        answer = answerService.findOne(this.getAnswerId());
        return SUCCESS;
    }

    public Answer getAnswer() {
        return answer;
    }

    public String getForm() {
        return SUCCESS;
    }

    public long getAnswerId() { return answerID; }

    public void setAnswerId(long answerID) {
        this.answerID = answerID;
    }
}
