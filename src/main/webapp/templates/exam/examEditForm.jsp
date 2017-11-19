<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 09/11/2017
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<s:form action="saveQuestion">
    <s:textfield name="question.questiontext" label="Fragentext"/>
    <s:textfield name="question.numberofanswers" label="Anzahl Anwortmöglichkeiten"/>
    <s:submit value="Send"/>
</s:form>
