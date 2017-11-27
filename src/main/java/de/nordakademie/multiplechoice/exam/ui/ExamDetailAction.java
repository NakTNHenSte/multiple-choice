package de.nordakademie.multiplechoice.exam.ui;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.multiplechoice.answer.model.Answer;
import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.exam.service.ExamService;
import de.nordakademie.multiplechoice.answer.service.AnswerService;
import de.nordakademie.multiplechoice.participation.model.Participation;
import de.nordakademie.multiplechoice.participation.service.ParticipationService;
import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.question.service.QuestionService;
import de.nordakademie.multiplechoice.testAnswer.service.TestAnswerService;
import de.nordakademie.multiplechoice.user.service.UserService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class ExamDetailAction extends ActionSupport implements Action, SessionAware {


    private final ExamService examService;
    private UserService userService;
    private QuestionService questionService;
    private ParticipationService participationService;
    private AnswerService answerService;


    Map<String, Object> session;
    private TestAnswerService testAnswerService;

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    private Exam exam;
    private long examId;
    private long userId;

    private List<Participation> participations;
    private List<Question> questions;
    private List<Answer> answers;

    @Autowired
    public ExamDetailAction(final ExamService examService, UserService userService, QuestionService questionService, ParticipationService participationService, AnswerService answerService, TestAnswerService testAnswerService) {
        this.examService = examService;
        this.userService = userService;
        this.questionService = questionService;
        this.participationService = participationService;
        this.answerService = answerService;
        this.testAnswerService = testAnswerService;
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

    /**
     * Diese Methode handled das Löschen von Prüfungen. Um eine Prüfung vollständig zu
     * löschen werden erst die enthaltenen Fragen und Antworten gelöscht.
     * Eine Prüfung kann nur unter bestimmten Bedingungen gelöscht werden.
     * @return Action Result Konstante.
     */
    public String removeExam() {
        exam = examService.findOne(examId);

        if (isEditableExam(exam.getEnd(),exam.getStart())) {
            questions = questionService.findByExam(examId);
            for (Question question : questions) {
                answers = answerService.findAll(question.getId());
                for (Answer answer : answers) {
                    answerService.delete(answer.getAnswerID());
                }
                questionService.delete(question.getId());
            }
            participationService.deleteByExam(examId);
            examService.removeExam(examId);
            testAnswerService.deleteAllByExam(examId);
            return SUCCESS;
        } else {
            addActionError("Prüfung kann erst nach Ende des Prüfungszeitraums gelöscht werden");
            return INPUT;
        }
    }

    private void loadExamData() {
        participations = participationService.findAll(this.getExamId());
        exam = examService.findOne(this.getExamId());
        questions = questionService.findByExam(exam.getId());
    }

    /**
     * Diese Methode handled das editieren von Exams.
     * @return Action Result Konstante.
     */
    public String editExam() {
        exam = examService.findOne(examId);

        if (isEditableExam(exam.getEnd(),exam.getStart())) {
            loadExamData();
            return SUCCESS;
        } else {
            addActionError("Prüfung kann nach Beginn des Prüfungszeitraums nicht mehr editiert werden");
            return INPUT;
        }
    }

    /**
     * Diese Methode handled das Anzeigen von Prüfungen.
     * @return Action Result Konstante.
     */
    public String viewExam() {
        loadExamData();
        return SUCCESS;
    }

    /**
     * Diese Methode handled das Speichern und Updaten von Prüfungen.
     * @return Action Result Konstante.
     */
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

    public void validate() {
    }


    private boolean isEditableExam(Date endDate, Date startDate) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        if(startDate.after(currentTimestamp)){
            return true;
        }
        if (endDate.before(currentTimestamp)) {
            return true;
        } else {
            return false;
        }
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
