package de.nordakademie.multiplechoice.user.model;

import javax.persistence.*;

/**
 * Created by Dieke on 07.11.17.
 */


@Entity
@Table(name = "USER")
public class User {

    private long id;
    private String name;
    private String surname;
    private String username;
    private String role;
    private String password;

    public User(){
    }

    public User(final long id, final String name, final String surname, final String username, final String role, final String password){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.role = role;
        this.password = password;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    public String getRole() {
        return username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
