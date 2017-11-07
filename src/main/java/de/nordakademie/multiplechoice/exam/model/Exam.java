package de.nordakademie.multiplechoice.exam.model;

import de.nordakademie.multiplechoice.user.model.User;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;


@Entity
@Table(name = "EXAM")
public class Exam {

    private long id;
    private String title;
    private Time duration;
    private Short percentualSuccessThreshold;
    private Date start;
    private Date end;
    private Byte credits;
    private String seminar;
    private User user;

    public Exam() {
    }

    public Exam(final long id, final String title, User user) {
        this.id = id;
        this.title = title;
        this.user = user;
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
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
    public Short getPercentualSuccessThreshold() {
        return percentualSuccessThreshold;
    }

    public void setPercentualSuccessThreshold(Short percentualSuccessThreshold) {
        this.percentualSuccessThreshold = percentualSuccessThreshold;
    }
    @Basic
    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }
}