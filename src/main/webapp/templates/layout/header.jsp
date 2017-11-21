<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">

        <a class="navbar-brand" href="examList"><i class="fa fa-check-square-o" aria-hidden="true"></i>
            Multiple Choice</a>

        <div class="navbar-right">
            <s:a action="logout">
                <i>${sessionScope.userTyp}</i>
                <i>${sessionScope.username}</i>
                <i class="fa fa-sign-out fa-2x" aria-hidden="true"></i>
            </s:a>
        </div>

    </div>
</nav>