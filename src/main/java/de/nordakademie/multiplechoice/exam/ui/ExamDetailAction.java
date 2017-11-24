package de.nordakademie.multiplechoice.exam.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.exam.service.ExamService;
import de.nordakademie.multiplechoice.participation.model.Participation;
import de.nordakademie.multiplechoice.participation.service.ParticipationService;
import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.question.service.QuestionService;
import de.nordakademie.multiplechoice.user.service.UserService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class ExamDetailAction implements Action, SessionAware {


    private final ExamService examService;
    private UserService userService;
    private QuestionService questionService;
    private ParticipationService participationService;


    Map<String, Object> session;

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    private Exam exam;
    private long examId;
    private long userId;
    private boolean editableExam;

    private List<Participation> participations;
    private List<Question> questions;

    @Autowired
    public ExamDetailAction(final ExamService examService, UserService userService, QuestionService questionService, ParticipationService participationService) {
        this.examService = examService;
        this.userService = userService;
        this.questionService = questionService;
        this.participationService = participationService;
    }

    @Override
    public String execute() {

        return SUCCESS;
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

    public String removeExam() {
        examService.removeExam(this.getExamId());
        return SUCCESS;
    }

    public String viewExam() {

        participations = participationService.findAll(this.getExamId());


        exam = examService.findOne(this.getExamId());
        questions = questionService.findByExam(exam.getId());

        return SUCCESS;
    }

    public String saveExam() {


        exam.setUser(userService.find(userId));
        if (this.getExamId() == 0) {
            examService.create(getExam());
        } else {
            exam.setId(this.getExamId());
            examService.update(exam);
        }
        examId = exam.getId();

        return SUCCESS;
    }

    public boolean isEditableExam() {
        return editableExam;
    }

    public void setEditableExam(boolean editableExam) {
        this.editableExam = editableExam;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = session;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }
}
