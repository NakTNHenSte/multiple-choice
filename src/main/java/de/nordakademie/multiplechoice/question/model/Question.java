package de.nordakademie.multiplechoice.question.model;

import de.nordakademie.multiplechoice.exam.model.Exam;

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
    private Exam exam;


    public Question() {
    }

    public Question(long id, int scorePerCorrectChoice, int scorePerWrongChoice,
                    int scorePerMissingChoice, String questionText, Exam exam) {
        this.id = id;
        this.scorePerCorrectChoice = scorePerCorrectChoice;
        this.scorePerWrongChoice = scorePerWrongChoice;
        this.scorePerMissingChoice = scorePerMissingChoice;
        this.questionText = questionText;
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

    public void setScorePerCorrectChoice(int scorePerCorrectChoice) {
        this.scorePerCorrectChoice = scorePerCorrectChoice;
    }

    @Basic
    public double getScorePerWrongChoice() {
        return scorePerWrongChoice;
    }

    public void setScorePerWrongChoice(int scorePerWrongChoice) {
        this.scorePerWrongChoice = scorePerWrongChoice;
    }

    @Basic
    public double getScorePerMissingChoice() {
        return scorePerMissingChoice;
    }

    public void setScorePerMissingChoice(int scorePerMissingChoice) {
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
}


