<%-- 
    Document   : create-contact
    Created on : Sep 16, 2010, 6:18:31 PM
    Author     : enyo
--%>
<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.loitsch.matthias.newsletter.Contact" %>
<%@ page import="com.loitsch.matthias.newsletter.PMF" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%
    PersistenceManager pm = PMF.get().getPersistenceManager();
    String query = "select from " + Contact.class.getName() + " order by lastName range 0,5";
    List<Contact> contacts = (List<Contact>) pm.newQuery(query).execute();
    if (contacts.isEmpty()) {
%>
<p>There are no contacts.</p>
<%
    } else {
        for (Contact c : contacts) {

%>
<p><b><%= c.getFirstName() %></b></p>
<%
        }
    }
    pm.close();
%>

    </body>
</html>
