package de.nordakademie.multiplechoice.user.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.multiplechoice.user.model.User;
import de.nordakademie.multiplechoice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Dieke Luebberstedt on 09.11.17.
 */

public class UserListAction implements Action{

    private final UserService userService;
    private List<User> users;

    @Autowired
    public UserListAction(final UserService userService) { this.userService = userService; }

    @Override
    public String execute() {
        users = userService.findAll();
        return SUCCESS;
    }

    public List<User> getUsers() {
        return users;
    }

}
