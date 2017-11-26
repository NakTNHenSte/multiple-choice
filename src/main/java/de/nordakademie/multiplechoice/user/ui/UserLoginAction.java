package de.nordakademie.multiplechoice.user.ui;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.multiplechoice.user.model.User;
import de.nordakademie.multiplechoice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Dieke Luebberstedt on 09.11.17.
 */

public class UserLoginAction extends ActionSupport implements SessionAware {
    @Autowired
    private UserService userService;

    private Map<String, Object> sessionMap;
    private String username;
    private String password;
    private User user;

    public String login() {

        // ueberpruefe, ob der user bereits eine session besitzt
        if (sessionMap.containsKey("userId")) {
                return SUCCESS; // gehe zur Hauptseite
            }

        if (username != null && password != null){
            // wenn kein user in der session existiert, dann pruefe Benutzername und Passwort
            user = userService.findUser(username);
            if (user != null){
                if (password.equals(user.getPassword())) {

                    // setzte den user in die session
                    sessionMap.put("userId", user.getId());
                    sessionMap.put("userType", user.getType());
                    sessionMap.put("userFullName", user.getName()+" "+user.getSurname());

                    return SUCCESS; // gehe zur Hauptseite
                }
            }
            addActionError("Benutzername oder Passwort sind falsch!");
            return INPUT;
        }
        // ansonsten gehe wieder zur Login-Seite
        return INPUT;
    }

    public String logout() {
        // entferne alle zuvor in der session gespeicherten Werte
        if (sessionMap.containsKey("userId")) {
            sessionMap.remove("userId");
            sessionMap.remove("userType");
            sessionMap.remove("userFullName");
            addActionMessage("Erfolgreich abgemeldet.");
            return SUCCESS;
        }
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}