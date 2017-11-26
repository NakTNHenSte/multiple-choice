package de.nordakademie.multiplechoice.user.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.multiplechoice.user.model.User;
import de.nordakademie.multiplechoice.user.service.UserService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Dieke Luebberstedt on 09.11.17.
 */

public class UserListAction implements Action, SessionAware{

    private final UserService userService;
    private List<User> users;
    private User user;
    private Map<String, Object> sessionMap;

    @Autowired
    public UserListAction(final UserService userService) { this.userService = userService; }

    @Override
    public String execute() {
        user = userService.find((long) sessionMap.get("userId"));
        return SUCCESS;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

}
