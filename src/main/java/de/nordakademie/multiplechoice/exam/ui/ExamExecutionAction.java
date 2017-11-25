package de.nordakademie.multiplechoice.exam.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.exam.service.ExamService;
import de.nordakademie.multiplechoice.participation.model.Participation;
import de.nordakademie.multiplechoice.participation.service.ParticipationService;
import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExamExecutionAction implements Action {


    private final ExamService examService;

    private Exam exam;
    private long examId;
    private long userId;
    private String oneTimePassword;
    private ParticipationService participationService;
    private List<Question> questions;
    private QuestionService questionService;


    @Autowired
    public ExamExecutionAction(final ExamService examService, ParticipationService participationService, QuestionService questionService) {
        this.examService = examService;
        this.participationService = participationService;
        this.questionService = questionService;
    }

    @Override
    public String execute() {
        exam = examService.findOne(this.getExamId());
        questions = questionService.findByExam(exam.getId());
        return SUCCESS;
    }

    public String runExam() {

        Participation participation = participationService.findByUserIdAndExamId(userId, examId);

        if(participation != null && participation.getOneTimePassword().equals(oneTimePassword)){
            participation.setValid(true); // TODO: zu false ändern und in condition packen
            participationService.update(participation);
            return SUCCESS;
        }
        return ERROR;
    }

    public Exam getExam() {
        return exam;
    }

    public String getForm() {
        return SUCCESS;
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }


    public String getOneTimePassword() {
        return oneTimePassword;
    }

    public void setOneTimePassword(String oneTimePassword) {
        this.oneTimePassword = oneTimePassword;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
