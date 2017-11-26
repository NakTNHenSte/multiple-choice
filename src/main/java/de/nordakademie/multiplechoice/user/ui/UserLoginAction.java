package de.nordakademie.multiplechoice.user.ui;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import de.nordakademie.multiplechoice.user.model.User;
import de.nordakademie.multiplechoice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserLoginAction extends ActionSupport implements SessionAware {
    @Autowired
    private UserService userService;

    private Map<String, Object> sessionMap;
    private String username;
    private String password;
    private User user;

    public String login() {

        // check if the userName is already stored in the session
        if (sessionMap.containsKey("userId")) {
                return SUCCESS; // return welcome page
            }

        if (username != null && password != null){
            // if no userName stored in the session,
            // check the entered userName and password
            user = userService.findUser(username);
            if (user != null){
                if (password.equals(user.getPassword())) {

                    // add userName to the session
                    sessionMap.put("userId", user.getId());
                    sessionMap.put("userType", user.getType());
                    sessionMap.put("userFullName", user.getName()+" "+user.getSurname());

                    return SUCCESS; // return welcome page
                }
            }
            addActionError("Benutzername oder Passwort sind falsch!");
            return INPUT;
        }
        // in other cases, return login page
        return INPUT;
    }

    public String logout() {
        // remove userName from the session
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