<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 09.11.17
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table>
    <tr>
        <th>Id</th>
        <th>Frage</th>
        <th>richtig</th>
        <th>falsch</th>
        <th>fehlt</th>
    </tr>
    <s:iterator var="question" value="questions" status="stat">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="questionText"/></td>
            <td><s:property value="scorePerCorrectChoice"/></td>
            <td><s:property value="scorePerWrongChoice"/></td>
            <td><s:property value="scorePerMissingChoice"/></td>

            <s:form action="questionEdit">
                <s:hidden name="questionId" value="%{id}"/>
                <s:submit value="editieren" type="button" class="btn btn-primary"/>
            </s:form>

        </tr>
    </s:iterator>




</table>