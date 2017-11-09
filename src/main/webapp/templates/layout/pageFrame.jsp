<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>
    <link rel="shortcut icon" href="/static/images/favicon.ico"/>
    <title>Multiple Choice</title>
</head>
<body>
<div class="container">
    <tiles:insertAttribute name="header"/>
    <hr/>
    <tiles:insertAttribute name="content"/>
</div>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/jquery-3.2.1.min.js"></script>

</body>
</html>
