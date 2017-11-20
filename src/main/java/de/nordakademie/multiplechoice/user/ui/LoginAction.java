package de.nordakademie.multiplechoice.user.ui;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

    private Map<String, Object> sessionMap;
    private String username;
    private String password;

    public String login() {
        String loggedUser = null;

        // check if the userName is already stored in the session
        if (sessionMap.containsKey("username")) {
            loggedUser = (String) sessionMap.get("username");

            if (loggedUser != null && loggedUser.equals("admin")) {
                return SUCCESS; // return welcome page
            }
            return INPUT;
        }
        if (username != null && password != null){
            // if no userName stored in the session,
            // check the entered userName and password
            if (username.equals("admin")
                    && password.equals("nimda")) {

                // add userName to the session
                sessionMap.put("username", username);

                return SUCCESS; // return welcome page
            }
            addActionError("Benutzername oder Passwort sind falsch!");
            return INPUT;
        }
        // in other cases, return login page
        return INPUT;
    }

    public String logout() {
        // remove userName from the session
        if (sessionMap.containsKey("username")) {
            sessionMap.remove("username");
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