<%--
  Created by IntelliJ IDEA.
  User: Dieke Luebberstedt
  Date: 09.11.2017
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Nachname</th>
        <th>Benutzername</th>
        <th>Rolle</th>
    </tr>
        <tr>
            <td><s:property value="user.id"/></td>
            <td><s:property value="user.name"/></td>
            <td><s:property value="user.surname"/></td>
            <td><s:property value="user.username"/></td>
            <td><s:property value="user.typ"/></td>
        </tr>
</table>
