package de.nordakademie.multiplechoice.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import de.nordakademie.multiplechoice.user.model.User;
import de.nordakademie.multiplechoice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


public class PermissionInterceptor extends AbstractInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> sessionMap = ActionContext.getContext().getSession();

        if (sessionMap.containsKey("userId")) {

            final long userId = (long) sessionMap.get("userId");
            final User user = userService.find(userId);

//            Ueberpruefen, ob der angemeldete User ein Dozent ist. Ansonsten den Zugriff auf die Zeite verweigern

            if (user.getType().equals("D")) {

                return invocation.invoke();

            } else {
                return "forbiddenError";
            }
        }
        return invocation.invoke();
    }
}
