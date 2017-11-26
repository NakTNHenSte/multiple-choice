<%--
  Created by IntelliJ IDEA.
  User: Dieke Luebberstedt
  Date: 09.11.2017
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<div class="row">
    <div class="col"><b>Id: </b><s:property value="user.id"/></div>
</div>
<div class="row">
    <div class="col"><b>Name: </b><s:property value="user.name"/></div>
</div>
<div class="row">
    <div class="col"><b>Nachname: </b><s:property value="user.surname"/></div>
</div>
<div class="row">
    <div class="col"><b>Benutzername: </b><s:property value="user.username"/></div>
</div>


<br>
<p>
<table class="table table-sm">
        <tr>
            <th>Titel</th>
            <th>Dauer (in Minuten)</th>
            <th>Start</th>
            <th>Ende</th>
            <th>Credits</th>
            <th>Seminar</th>
            <th>Bestehensgrenze (in %)</th>
            <th>Prüfungsergebnis </th>
        </tr>
    <s:iterator value="participations">
        <tr>
            <td><s:property value="exam.title"/></td>
            <td><s:property value="exam.duration"/></td>
            <td><s:property value="exam.start"/></td>
            <td><s:property value="exam.end"/></td>
            <td><s:property value="exam.credits"/></td>
            <td><s:property value="exam.seminar"/></td>
            <td><s:property value="exam.percentualSuccessThreshold"/></td>
            <td><s:property value="examResult"/></td>
        </tr>
    </s:iterator>

</table>
</p>