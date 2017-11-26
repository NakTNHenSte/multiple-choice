<%--
  Created by IntelliJ IDEA.
  User: Dieke Luebberstedt
  Date: 09.11.2017
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<style type="text/css">
    .errors {
        background-color:#FFCCCC;
        border:1px solid #CC0000;
        width:400px;
        margin-bottom:8px;
    }
    .errors li{
        list-style: none;
    }
    .welcome {
        background-color:#DDFFDD;
        border:1px solid #009900;
        width:400px;
    }
    .welcome li{
        list-style: none;
    }
</style>
<body>
<center>
    <h3>Bitte melden Sie sich an</h3>
    <s:form action="login" method="post">
        <s:textfield name="username" label="Benutzername" />
        <s:password name="password" label="Passwort" />
        <s:submit value="Anmelden" type="button" class="btn btn-primary" />
    </s:form>

    <s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror/>
        </div>
    </s:if>
    <s:if test="hasActionMessages()">
        <div class="welcome">
            <s:actionmessage/>
        </div>
    </s:if>

    <h3>Student: Benutzername: hans.petersen / Passwort: password</h3>
    <h3>Dozent: Benutzername: uwe.mayer / Passwort: nimda</h3>

</center>
</body>
</html>
