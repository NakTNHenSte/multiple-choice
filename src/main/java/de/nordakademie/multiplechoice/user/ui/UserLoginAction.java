package de.nordakademie.multiplechoice.user.ui;

/**
 * Created by Dieke Luebberstedt on 09.11.17.
 */

import com.opensymphony.xwork2.Action;
import org.springframework.beans.factory.annotation.Autowired;


public class UserLoginAction implements Action{

    @Autowired
    public UserLoginAction(){}

    public String loginUser(){
        return SUCCESS;
    }

    public String getForm(){
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
