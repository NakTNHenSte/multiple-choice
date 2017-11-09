package de.nordakademie.multiplechoice.question.model;

import de.nordakademie.multiplechoice.exam.model.Exam;

import javax.persistence.*;

/**
 * Created by chris on 07.11.17.
 */

@Entity
@Table(name = "QUESTION")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Basic
    private int scorePerCorrectChoice;
    @Basic
    private int scorePerWrongChoice;
    @Basic
    private int scorePerMissingChoice;
    @ManyToOne(optional = false)
    private Exam exam;


    public Question() {
    }

    public Question(long id, int scorePerCorrectChoice, int scorePerWrongChoice, int scorePerMissingChoice, Exam exam) {
        this.id = id;
        this.scorePerCorrectChoice = scorePerCorrectChoice;
        this.scorePerWrongChoice = scorePerWrongChoice;
        this.scorePerMissingChoice = scorePerMissingChoice;
        this.exam = exam;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getScorePerCorrectChoice() {
        return scorePerCorrectChoice;
    }

    public void setScorePerCorrectChoice(int scorePerCorrectChoice) {
        this.scorePerCorrectChoice = scorePerCorrectChoice;
    }

    public int getScorePerWrongChoice() {
        return scorePerWrongChoice;
    }

    public void setScorePerWrongChoice(int scorePerWrongChoice) {
        this.scorePerWrongChoice = scorePerWrongChoice;
    }

    public int getScorePerMissingChoice() {
        return scorePerMissingChoice;
    }

    public void setScorePerMissingChoice(int scorePerMissingChoice) {
        this.scorePerMissingChoice = scorePerMissingChoice;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}


