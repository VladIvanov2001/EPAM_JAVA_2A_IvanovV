<%--
  Created by IntelliJ IDEA.
  User: vladi
  Date: 24.02.2020
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>First servlet</title>
  <style>
    .btn{
      position: relative;
      left: 20vw;
      bottom: 10vh;
    }
    .txt_for_term {
      position: relative;
      bottom: 75px;
      left: 30vh;
    }

  </style>
</head>
<body>
<p>App for adding two numbers</p>
<form action="controller" method="post">
  <p>first number</p>
  <input type="text" name="num1" value="" autofocus/>
  <p class="txt_for_term">second number</p>
  <input type="text" name="num2" value="" autofocus class="txt_for_term"/>
  <input type="submit" name="exec" value="Post" class="btn"/>
</form>
</body>
</html>
