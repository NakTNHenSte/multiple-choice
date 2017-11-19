<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 09.11.17
  Time: 09:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table class="table">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Titel</th>
        <th scope="col">Dozent</th>
        <th scope="col">Seminar</th>
        <th scope="col">Credits</th>
        <th scope="col">Prüfungszeitraum</th>
    </tr>
    <s:iterator value="exams">
        <tr>
            <td><s:a href="examDetail?examId=%{id}"> <s:property value="id"/></s:a></td>
            <td><s:property value="title"/></td>
            <td><s:property value="user"/></td>
            <td><s:property value="seminar"/></td>
            <td><s:property value="credits"/></td>
            <td><s:property value="start"/> - <s:property value="end"/></td>
        </tr>
    </s:iterator>
</table>
