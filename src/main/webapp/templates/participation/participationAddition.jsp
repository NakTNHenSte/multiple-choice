<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 23/11/2017
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="addParticipation">

<s:select label="Fügen Sie einen Teilnehmer hinzu"
          list="students"
          listValue="%{name + '  ' +  surname}"
          listKey="id"
          name="user"/>

    <s:hidden name="examId" value="%{examId}"/>
    <s:submit value="Teilnehmer hinzufügen" type="button" class="btn btn-secondary" name="submit"/>
</s:form>
