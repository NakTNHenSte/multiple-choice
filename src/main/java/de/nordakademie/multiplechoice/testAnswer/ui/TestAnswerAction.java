package de.nordakademie.multiplechoice.testAnswer.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.multiplechoice.answer.model.Answer;
import de.nordakademie.multiplechoice.answer.service.AnswerService;
import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.exam.service.ExamService;
import de.nordakademie.multiplechoice.participation.model.Participation;
import de.nordakademie.multiplechoice.participation.service.ExamResultEnum;
import de.nordakademie.multiplechoice.participation.service.ParticipationService;
import de.nordakademie.multiplechoice.testAnswer.service.TestAnswerService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestAnswerAction extends ActionSupport implements SessionAware {


    private long examId;
    private long answerId;
    private long questionId;
    private Exam exam;
    private List<String> givenAnswers = new ArrayList<>();
    private int currentQuestionIndex;
    private TestAnswerService testAnswerService;
    private Map<String, Object> sessionMap;
    private AnswerService answerService;
    private ExamService examService;
    private ParticipationService participationService;


    @Autowired
    public TestAnswerAction(TestAnswerService testAnswerService, AnswerService answerService, ExamService examService, ParticipationService participationService) {
        this.testAnswerService = testAnswerService;
        this.answerService = answerService;
        this.examService = examService;
        this.participationService = participationService;
    }

    public String saveTestAnswers() {

        if (isSavingAnswersAllowed()) {

            for (int i = 0; i < givenAnswers.size(); i++) {
                Answer answerFromDatabase = answerService.findAll(questionId).get(i);
                testAnswerService.create(givenAnswers.get(i), examId, (long) sessionMap.get("userId"), answerFromDatabase.getAnswerID());
            }
            return SUCCESS;

        }
        return ERROR;
    }

    @Override
    public String execute() {
        exam = examService.findOne(examId);
        return SUCCESS;
    }

    public String finishExam() {

        long userId = (long) sessionMap.get("userId");
        Participation participation = participationService.findByUserIdAndExamId(userId, examId);

        if ((testAnswerService.getAchievedPointsInExam(userId, examId) / examService.getMaximumPointsInExam(examId)) * 100 >= participation.getExam().getPercentualSuccessThreshold()) {
            participation.setExamResult(ExamResultEnum.PASSED.getExamResult());

        } else {
            participation.setExamResult(ExamResultEnum.FAILED.getExamResult());
        }
        participationService.update(participation);

        return SUCCESS;
    }

    private boolean isSavingAnswersAllowed() {
        Participation participation = participationService.findByUserIdAndExamId((long) sessionMap.get("userId"), examId);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Timestamp examStartTimestamp;
        examStartTimestamp = participation.getExamStartTimestamp();

        if (((now.getTime() / 1000) - (examStartTimestamp.getTime() / 1000)) / 60 < participation.getExam().getDuration()) {
            addActionError("Die Bearbeitungszeit ist abgelaufen.");
            return true;

        } else {
            return false;
        }

    }

    @Override
    public void validate() {
        Exam exam = examService.findOne(examId);

    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public List<String> getGivenAnswers() {
        return givenAnswers;
    }

    public void setGivenAnswers(List<String> givenAnswers) {
        this.givenAnswers = givenAnswers;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
