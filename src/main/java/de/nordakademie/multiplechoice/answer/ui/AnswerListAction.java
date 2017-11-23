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

    private long answerId;

    private long questionId;

    @Autowired
    public AnswerListAction(final AnswerService answerService) {
        this.answerService = answerService;
    }

    @Override
    public String execute() {
        answers = answerService.findAll(questionId);
        return SUCCESS;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String deleteAnswer(){
        answerService.delete(this.getAnswerId());
        return SUCCESS;
    }

    public long getAnswerId() { return answerId; }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }
}