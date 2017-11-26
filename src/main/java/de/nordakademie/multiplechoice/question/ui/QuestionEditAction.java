package de.nordakademie.multiplechoice.question.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.multiplechoice.answer.model.Answer;
import de.nordakademie.multiplechoice.answer.service.AnswerService;
import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.exam.service.ExamService;
import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 18.11.17.
 */
public class QuestionEditAction extends ActionSupport {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private Question question;
    private long questionId;
    private int positionOfAnswer;
    private List<Answer> answerList = new ArrayList<Answer>();
    private int answerCount;
    private Answer answer;
    private long examId;
    private Exam exam;
    private ExamService examService;

    @Autowired
    public QuestionEditAction(final QuestionService questionService, final AnswerService answerService, ExamService examService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.examService = examService;
    }

    public String editQuestion() {

        question = questionService.findOne(questionId);
        answerList = answerService.findAll(questionId);
        answerCount = answerList.size();
        exam = examService.findOne(question.getExam().getId());
        examId = exam.getId();
        questionId = question.getId();

        if(question.getQuestionType().equals("multiple")){
            return INPUT;
        }
        return SUCCESS;
    }

    public String cancel() {

        exam = examService.findOne(examId);
        return "cancel";
    }


    public String getForm() {
        exam = examService.findOne(examId);
        return SUCCESS;
    }

    public String saveBlankText(){
        return SUCCESS;
    }

    public String saveQuestion() {

        exam = question.getExam();
        question.setQuestionType("multiple");

        for (int i = 0; i < answerCount; i++) {
            answerList.add(new Answer());
        }

        exam = examService.findOne(examId);

        questionService.create(question, examId);

        for (Answer answer : answerList) {
            answer.setQuestion(question);
            answerService.create(answer);
        }
        return SUCCESS;
    }

    public String saveAnswerEdit() {

        List<Answer> answersFromDatabase = answerService.findAll(questionId);

        if (answerList.size() == answersFromDatabase.size()) {
            for (int i = 0; i < answerList.size(); i++) {
            answerList.get(i).setQuestion(answersFromDatabase.get(i).getQuestion());
            answerList.get(i).setAnswerID(answersFromDatabase.get(i).getAnswerID());
            answerService.update(answerList.get(i));
            }
        }

        return SUCCESS;
    }

    public String saveQuestionEdit() {

        question.setExam(examService.findOne(examId));
        question.setQuestionType("multiple");
        if (this.getQuestionId() == 0) {
            questionService.create(getQuestion(), examId);
        } else {
            question.setId(this.getQuestionId());
            questionService.update(question);
        }
        examId = question.getExam().getId();

        return SUCCESS;
    }

    public String deleteAnswer() {
        answerList = answerService.findAll(questionId);
        answerService.delete(answerList.get(positionOfAnswer).getAnswerID());
        return SUCCESS;
    }

    public String deleteQuestion() {
        answerList = answerService.findAll(questionId);
        for (Answer answer : answerList) {
            answerService.delete(answer.getAnswerID());
        }
        questionService.delete(questionId);
        return SUCCESS;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(final Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
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

    public void setExamId(long examId) {
        this.examId = examId;
    }


    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public long getExamId() {
        return examId;
    }

    public void getExamId(long examId) {
        this.examId = examId;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public int getPositionOfAnswer() {
        return positionOfAnswer;
    }

    public void setPositionOfAnswer(int positionOfAnswer) {
        this.positionOfAnswer = positionOfAnswer;
    }
}
