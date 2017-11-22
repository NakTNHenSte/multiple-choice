package de.nordakademie.multiplechoice.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import de.nordakademie.multiplechoice.user.model.User;
import de.nordakademie.multiplechoice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


public class LoginInterceptor extends AbstractInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> sessionMap = ActionContext.getContext().getSession();

        final long userId = (long) sessionMap.get("userId");
        final User user = userService.find(userId);

        if (user == null)
        {
            return "loginRedirect";
        }
        else
        {
            return invocation.invoke();
        }
    }
}
