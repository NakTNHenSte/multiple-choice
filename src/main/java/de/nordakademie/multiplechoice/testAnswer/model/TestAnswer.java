package de.nordakademie.multiplechoice.testAnswer.model;

/**
 * Created by Daniel Fiolka on 25.11.2017
 */

import de.nordakademie.multiplechoice.answer.model.Answer;
import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.user.model.User;

import javax.persistence.*;

/**
 * Diese Entität stellt die gegebene Antwort eines Studenten auf eine Testfrage dar.
 * Da es um multiple choice Tests geht, korrespondieren diese Antworten eins zu eins
 * zu den eingetragenen Antworten des Dozenten.
 */
@Entity
@Table(name = "testAnswer")
public class TestAnswer {

    private long id;
    private String studentAnswer;
    private Exam exam;
    private User user;
    private Answer answer;
    private String correctness;

    public TestAnswer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    @ManyToOne(optional = false)
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @OneToOne
    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @OneToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCorrectness(String correctness) {
        this.correctness = correctness;
    }

    @Basic
    public String getCorrectness() {
        return correctness;
    }
}

