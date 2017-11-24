<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 23/11/2017
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:select label="Fügen Sie einen Teilnehmer hinzu"
          headerKey="-1" headerValue="wtf macht das hier"
          list="students"
          name="user.name"/>

<s:form action="participationAddition">
    <s:hidden name="examId" value="%{exam.id}"/>
    <s:submit value="Teilnehmer hinzufügen" type="button" class="btn btn-secondary"/>
</s:form>