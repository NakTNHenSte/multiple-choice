package de.nordakademie.multiplechoice.participation.model;

import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.user.model.User;

import javax.persistence.*;
import java.sql.Timestamp;



/**
 * Created by Daniel Fiolka on 23.11.17.
 * Diese Entität stellt eine Teilnahme an einer Prüfung dar.
 * Ein Benutzer bzw. Student kann mehrere Teilnahmen an unterschiedlichen Prüfungen haben,
 * aber immer nur einmal an ein und der selben Prüfung teilnehmen.
 * Über diese Entität wird ihm auch ein Einmalpasswort und ein Testergebnis zugeordnet.
 */
@Entity
@Table(name = "PARTICIPATION")
public class Participation {

    private long id;
    private User user;
    private String oneTimePassword;
    private boolean valid;
    private Exam exam;
    private String examResult;
    private Timestamp examStartTimestamp;

    public Participation() {
    }

    public Participation(final long id, final String name, final String surname, final String username, final String typ, final String OneTimePassword, final String examResult) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }


    @Basic
    public String getOneTimePassword() { return oneTimePassword;
    }

    public void setOneTimePassword(String oneTimePassword) {
        this.oneTimePassword = oneTimePassword;
    }

    @OneToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @ManyToOne
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }


    @Basic
    public String getExamResult() {
        return examResult;
    }

    public void setExamResult(String examResult) {
        this.examResult = examResult;
    }

    @Basic
    public Timestamp getExamStartTimestamp() {
        return examStartTimestamp;
    }

    public void setExamStartTimestamp(Timestamp examStartTimestamp) {
        this.examStartTimestamp = examStartTimestamp;
    }
}