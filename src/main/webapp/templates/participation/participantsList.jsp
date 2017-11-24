<%--
  Created by IntelliJ IDEA.
  User: Dieke Luebberstedt
  Date: 09.11.2017
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="participationAddition">
    <s:hidden name="examId" value="%{examId}"/>
    <s:submit value="Teilnehmer hinzufügen" type="button" class="btn btn-secondary"/>
</s:form>

<table class="table table-sm">
    <tr>
        <th>Name</th>
        <th>Nachname</th>
        <th>Einmalpasswort</th>
        <th>Gültigkeit des PW</th>
        <th>Aktionen</th>
    </tr>
    <s:iterator value="participations">
        <tr>
            <td><s:property value="user.name"/></td>
            <td><s:property value="user.surname"/></td>
            <td><s:property value="oneTimePassword"/></td>
            <td><s:property value="valid"/></td>
            <td><s:form action="removeParticipation">
                <s:hidden name="participationId" value="%{id}"/>
                <s:hidden name="examId" value="%{examId}"/>
                <s:submit value="Teilnehmer entfernen" type="button" class="btn btn-danger"/>
            </s:form>
            </td>
        </tr>
    </s:iterator>
</table>
