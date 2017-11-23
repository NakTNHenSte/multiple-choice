package de.nordakademie.multiplechoice.question.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.multiplechoice.answer.model.Answer;
import de.nordakademie.multiplechoice.answer.service.AnswerService;
import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 22.11.17.
 */

public class QuestionFillTheBlankTextAction extends ActionSupport {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private Question question;

    private List<Answer> answerList = new ArrayList<Answer>();

    private final String startRegex = "$$";
    private final String endRegex = "%%";
    private Exam exam;


    @Autowired
    public QuestionFillTheBlankTextAction(final QuestionService questionService, final AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    public String getForm() { return SUCCESS; }

    /**
     * Die Methode speichert den Lueckentext und die daraus extrahierten Antworten.
     * @return
     */
    public String saveQuestionBlankText() {

        questionService.create(question, exam.getId());
        List<String> blanksList = extractAnswers(question.getQuestionText());

        answerList = createAnswerList(blanksList);

        for (Answer answer : answerList) {
            answer.setQuestion(question);
            answerService.create(answer);
        }
        return SUCCESS;
    }

    private List<Answer> createAnswerList(List<String> blanksList) {

        List<Answer> answers = new ArrayList<Answer>();

        for (String blank : blanksList) {
            Answer extractedAnswer = new Answer();
            extractedAnswer.setAnswerText(blank);
            extractedAnswer.setTrueOrFalse("true");
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
}

