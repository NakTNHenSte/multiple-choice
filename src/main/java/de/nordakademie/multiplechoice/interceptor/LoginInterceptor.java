package de.nordakademie.multiplechoice.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import de.nordakademie.multiplechoice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Dieke Luebberstedt on 18.11.17.
 */

public class LoginInterceptor extends AbstractInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> sessionMap = ActionContext.getContext().getSession();

        // pruefe ob eine session existiert. wenn nicht, dann gehe zum Login, andernfalls unternimm nichts weiteres
        if (!sessionMap.containsKey("userId"))
        {
            return "loginRedirect";
        }
        else
        {
            return invocation.invoke();
        }
    }
}
