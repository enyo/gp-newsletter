<%-- 
    Document   : create-contact
    Created on : Sep 16, 2010, 6:18:31 PM
    Author     : enyo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <form action="create-contact" method="post">

        Title: <input name="title" /><br />
        First name: <input name="firstName" /><br />
        Middle name: <input name="middleName" /><br />
        Last name: <input name="lastName" /><br />
        E-mail: <input name="email" /><br />
        Note: <textarea  name="email"></textarea><br />
        <input type="submit" value="save" />
      </form>
    </body>
</html>
