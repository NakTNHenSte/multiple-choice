package de.nordakademie.multiplechoice.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "EXAM")
public class Exam {

    private long id;
    private String title;
    public Exam() {
    }

    public Exam(final long id, final String title) {
        this.id = id;
        this.title = title;
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



}