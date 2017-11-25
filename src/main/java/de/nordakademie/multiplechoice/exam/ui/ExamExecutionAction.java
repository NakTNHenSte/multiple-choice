package de.nordakademie.multiplechoice.exam.ui;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import de.nordakademie.multiplechoice.answer.model.Answer;
import de.nordakademie.multiplechoice.answer.service.AnswerService;
import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.exam.service.ExamService;
import de.nordakademie.multiplechoice.participation.model.Participation;
import de.nordakademie.multiplechoice.participation.service.ParticipationService;
import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ExamExecutionAction extends ActionSupport implements Preparable {


    private final ExamService examService;

    private Exam exam;
    private long examId;
    private long userId;
    private String oneTimePassword;
    private ParticipationService participationService;
    private List<Question> questions;
    private QuestionService questionService;
    private Question question;
    private int currentQuestionIndex;
    private List<Answer> answerList;
    private AnswerService answerService;
    private int answerCount;
    private List<Answer> givenAnswers = new ArrayList<>();


    @Autowired
    public ExamExecutionAction(final ExamService examService, ParticipationService participationService, QuestionService questionService, AnswerService answerService) {
        this.examService = examService;
        this.participationService = participationService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @Override
    public String execute() {
        loadQuestions();
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
    }

    private void loadQuestions() {
        exam = examService.findOne(this.getExamId());
        questions = questionService.findByExam(exam.getId());
    }

    private void loadCurrentQuestion() {
        question = questions.get(currentQuestionIndex);
        answerList = answerService.findAll(question.getId());
        answerCount = answerList.size();

        for (int i=0; i < answerCount; i++) {
            givenAnswers.add(new Answer());
        }
    }

    public String nextQuestion() {
        loadQuestions();

        if (questions.size() > currentQuestionIndex + 1) {
            currentQuestionIndex++;
        }
        loadCurrentQuestion();
        return SUCCESS;
    }

    public String previousQuestion() {
        loadQuestions();

        if (0 < currentQuestionIndex) {
            currentQuestionIndex--;
        }
        loadCurrentQuestion();

        return SUCCESS;
    }

    public String runExam() {
        loadQuestions();
        currentQuestionIndex = 0;
        loadCurrentQuestion();


        Participation participation = participationService.findByUserIdAndExamId(userId, examId);

        if (participation != null && participation.getOneTimePassword().equals(oneTimePassword)) {
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

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public void setGivenAnswers(List<Answer> givenAnswers) {
        this.givenAnswers = givenAnswers;
    }

    public List<Answer> getGivenAnswers() {
        return givenAnswers;
    }

}
