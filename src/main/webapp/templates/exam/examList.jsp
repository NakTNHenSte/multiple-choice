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
<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Duration</th>
    </tr>
    <s:iterator value="exams">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="title"/></td>
            <td><s:property value="duration"/></td>
        </tr>
    </s:iterator>
</table>
