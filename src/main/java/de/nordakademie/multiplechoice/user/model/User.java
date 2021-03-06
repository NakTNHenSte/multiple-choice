package de.nordakademie.multiplechoice.user.model;

import javax.persistence.*;



/**
 * Created by Dieke Luebberstedt on 07.11.17.
 * Diese Entität stellt eines Benutzer der Anwendung dar.
 */
@Entity
@Table(name = "USER")
public class User {

    private long id;
    private String name;
    private String surname;
    private String type;
    private String username;
    private String password;

    public User(){
    }

    public User(final long id, final String name, final String surname, final String username, final String type, final String password){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.type = type;
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
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
