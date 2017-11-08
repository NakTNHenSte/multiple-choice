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

import de.nordakademie.multiplechoice.question.model.Question;

@Entity
@Table(name = "Answer")
public class Answer {

    private long answerID;
    private long questionID;
    private boolean trueOrFalse;
    private String answerText;

    public Answer() {
    }

    public Answer(final long answerID, long questionID, final boolean trueOrFalse, final String answerText) {
        this.answerID = answerID;
        this.questionID = questionID;
        this.trueOrFalse = trueOrFalse;
        this.answerText = answerText;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getAnswerID() {
        return questionID;
    }

    public void setAnswerID(final long answerID) {
        this.answerID = answerID;
    }

    @Basic
    public long getQuestionID() { return questionID; }

    public void setQuestionID(final long questionID) {
        this.questionID = questionID;
    }

    @Basic
    public boolean getTrueOrFalse() { return trueOrFalse; }

    public void setTrueOrFalse(final boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }

    @Basic
    public String getAnswerText() { return answerText; }

    public void setAnswerText(final String answerText) {
        this.answerText = answerText;
    }
}

