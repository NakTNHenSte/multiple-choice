package de.nordakademie.multiplechoice.answer.ui;

/**
 * Created by Steven on 19.11.2017.
 */
import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.multiplechoice.answer.model.Answer;
import de.nordakademie.multiplechoice.answer.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;


public class AnswerEditAction extends ActionSupport{

    private final AnswerService answerService;

    private Answer answer;

    @Autowired
    public AnswerEditAction(final AnswerService answerService){
        this.answerService = answerService;
    }

    public String getForm() {
        return SUCCESS;
    }

    public String saveAnswer(){
        answerService.create(answer);
        return SUCCESS;
    }

    @Override
    public void validate(){}

    public Answer getAnswer(){return answer;}

    public void setAnswer(final Answer answer){this.answer = answer;}
    }
