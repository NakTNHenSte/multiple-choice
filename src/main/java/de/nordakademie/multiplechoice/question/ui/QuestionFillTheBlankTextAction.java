package de.nordakademie.multiplechoice.question.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.multiplechoice.answer.model.Answer;
import de.nordakademie.multiplechoice.answer.service.AnswerService;
import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.question.service.QuestionService;
import de.nordakademie.multiplechoice.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 22.11.17.
 */

public class QuestionFillTheBlankTextAction extends ActionSupport {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final ExamService examService;
    private Question question;

    private List<Answer> answerList = new ArrayList<Answer>();

    private final String startRegex = "_%";
    private final String endRegex = "%_";
    private Exam exam;
    private long examId;
    private long questionId;


    @Autowired
    public QuestionFillTheBlankTextAction(final QuestionService questionService, final AnswerService answerService, final ExamService examService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.examService = examService;
    }

    public String getForm() { return SUCCESS; }

    /**
     * Die Methode speichert den Lueckentext und die daraus extrahierten Antworten.
     *
     * @return
     */
    public String saveQuestionBlankText() {

        question.setExam(examService.findOne(this.getExamId()));
        question.setQuestionTyp("gap");
        question.setId(this.getQuestionId());
        if (this.getQuestionId() == 0) {
            questionService.create(question, getExamId());
            parseAnswers();
        } else {
            questionService.update(question);

            answerList = answerService.findAll(question.getId());

            for (Answer answer : answerList) {
                answerService.delete(answer.getAnswerID());
            }
            parseAnswers();
        }

        return SUCCESS;
    }

    private void parseAnswers() {
        List<String> blanksList = extractAnswers(question.getQuestionText());

        answerList = createAnswerList(blanksList);


        for (Answer answer : answerList) {
            answer.setQuestion(question);
            answerService.create(answer);
        }
    }

    private List<Answer> createAnswerList(List<String> blanksList) {

        List<Answer> answers = new ArrayList<Answer>();

        for (String blank : blanksList) {
            Answer extractedAnswer = new Answer();
            extractedAnswer.setAnswerText("luecke");
            extractedAnswer.setTrueOrFalse(blank);
            extractedAnswer.setQuestion(question);
            answers.add(extractedAnswer);

        }
        return answers;
    }

    private List<String> extractAnswers(String blankText) {

        List<String> answers = new ArrayList<String>();

        if (blankText != null) {
            while (blankText.contains(startRegex)) {

                int startGap = blankText.indexOf(startRegex, 0);
                int endGap = blankText.indexOf(endRegex, 0);
                answers.add(blankText.substring(startGap + startRegex.length(), endGap));

                blankText = blankText.substring(endGap + endRegex.length());

            }
        }
        return answers;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(final Question question) {
        this.question = question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }
}

