<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 09.11.17
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table class="table table-sm">
    <tr>
        <th>Frage</th>
        <th>richtig</th>
        <th>falsch</th>
        <th>fehlt</th>
        <th>Aktionen</th>

    </tr>
    <s:iterator var="question" value="questions" status="stat">
        <tr>
            <td><s:property value="questionText"/></td>
            <td><s:property value="scorePerCorrectChoice"/></td>
            <td><s:property value="scorePerWrongChoice"/></td>
            <td><s:property value="scorePerMissingChoice"/></td>

            <td><s:form action="questionEdit">
                <s:hidden name="questionId" value="%{id}"/>
                <s:submit value="editieren" type="button" class="btn btn-primary"/>
            </s:form>
            </td>

            <td><s:form action="deleteQuestion">
                <s:hidden name="questionId" value="%{id}"/>
                <s:hidden name="examId" value="%{examId}"/>
                <s:submit value="löschen" type="button" class="btn btn-danger"/>
            </s:form>
            </td>
        </tr>
    </s:iterator>




</table>