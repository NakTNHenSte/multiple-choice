package de.nordakademie.multiplechoice.answer.model;

/**
 * Created by Steven on 08.11.2017.
 */

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.question.model.Question;

@Entity
@Table(name = "Answer")
public class Answer {

    private long answerID;
    private Question question;
    private String trueOrFalse;
    private String answerText;
    private int positionOfAnswer;

    public Answer() {
    }

    public Answer(final long answerID, Question question, final String trueOrFalse, final String answerText, final int positionOfAnswer) {
        this.answerID = answerID;
        this.question = question;
        this.trueOrFalse = trueOrFalse;
        this.answerText = answerText;
        this.positionOfAnswer = positionOfAnswer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(final long answerID) {
        this.answerID = answerID;
    }

    @Basic
    public String getTrueOrFalse() { return trueOrFalse; }

    public void setTrueOrFalse(final String trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }

    @Basic
    public String getAnswerText() { return answerText; }

    public void setAnswerText(final String answerText) {
        this.answerText = answerText;
    }

    @ManyToOne(optional = false)
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Basic
    public int getPositionOfAnswer() {
        return positionOfAnswer;
    }

    public void setPositionOfAnswer(int positionOfAnswer) {
        this.positionOfAnswer = positionOfAnswer;
    }
}

