<%--
  Created by IntelliJ IDEA.
  User: Dieke Luebberstedt
  Date: 09.11.2017
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<center>
<h3>Bitte melden Sie sich an</h3>

        <s:form action="loginUser">
             <s:textfield name="username" label="Benutzername"/>
             <s:password name="password" label="Passwort"/>
             <s:submit value="Anmelden"/>
        </s:form>

</center>