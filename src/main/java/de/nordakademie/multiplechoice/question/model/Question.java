package de.nordakademie.multiplechoice.question.model;

import de.nordakademie.multiplechoice.exam.model.Exam;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by chris on 07.11.17.
 */

@Entity
@Table(name = "QUESTION")
public class Question {

    private long id;
    private double scorePerCorrectChoice;
    private double scorePerWrongChoice;
    private double scorePerMissingChoice;
    private String questionText;
    private String questionTyp;
    private Exam exam;


    public Question() {
    }

    public Question(long id, double scorePerCorrectChoice, double scorePerWrongChoice,
                    double scorePerMissingChoice, String questionText, String questionTyp, Exam exam) {
        this.id = id;
        this.scorePerCorrectChoice = scorePerCorrectChoice;
        this.scorePerWrongChoice = scorePerWrongChoice;
        this.scorePerMissingChoice = scorePerMissingChoice;
        this.questionText = questionText;
        this.questionTyp = questionTyp;
        this.exam = exam;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    public double getScorePerCorrectChoice() {
        return scorePerCorrectChoice;
    }

    public void setScorePerCorrectChoice(double scorePerCorrectChoice) {
        this.scorePerCorrectChoice = scorePerCorrectChoice;
    }

    @Basic
    public double getScorePerWrongChoice() {
        return scorePerWrongChoice;
    }

    public void setScorePerWrongChoice(double scorePerWrongChoice) {
        this.scorePerWrongChoice = scorePerWrongChoice;
    }

    @Basic
    public double getScorePerMissingChoice() {
        return scorePerMissingChoice;
    }

    public void setScorePerMissingChoice(double scorePerMissingChoice) {
        this.scorePerMissingChoice = scorePerMissingChoice;
    }

    @Basic
    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    @ManyToOne(optional = false)
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public String getQuestionTyp() {
        return questionTyp;
    }

    public void setQuestionTyp(String questionTyp) {
        this.questionTyp = questionTyp;
    }
}
