package de.nordakademie.multiplechoice.exam.model;

import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.user.model.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


/**
 * Created by Daniel Fiolka on 08.11.17.
 */
@Entity
@Table(name = "EXAM")
public class Exam {

    private long id;
    private String title;
    private short duration;
    private short percentualSuccessThreshold;
    private Date start;
    private Date end;
    private byte credits;
    private String seminar;
    private String user;
    private List<User> participants;
    private List<Question> questions;

    public Exam() {
    }

    public Exam(final long id, final String title, String user, short duration,short percentualSuccessThreshold,
                Date start, Date end, byte credits, String seminar) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.duration = duration;
        this.percentualSuccessThreshold = percentualSuccessThreshold;
        this.start = start;
        this.end = end;
        this.credits = credits;
        this.seminar = seminar;
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
    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    @Basic
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    public String getSeminar() {
        return seminar;
    }

    public void setSeminar(String seminar) {
        this.seminar = seminar;
    }

    @Basic
    public Byte getCredits() {
        return credits;
    }

    public void setCredits(Byte credits) {
        this.credits = credits;
    }

    @Basic
    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Basic
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    @Basic
    public short getPercentualSuccessThreshold() {
        return percentualSuccessThreshold;
    }

    public void setPercentualSuccessThreshold(short percentualSuccessThreshold) {
        this.percentualSuccessThreshold = percentualSuccessThreshold;
    }

    @Basic
    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    @ManyToMany
    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}