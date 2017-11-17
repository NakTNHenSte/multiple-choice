<%--
  Created by IntelliJ IDEA.
  User: Dieke Luebberstedt
  Date: 09.11.2017
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<s:form action="loginUser">
    <s:textfield name="user.username" label="Benutzername"/>
    <s:textfield name="user.password" label="Passwort"/>
    <s:submit value="Send"/>
</s:form>
