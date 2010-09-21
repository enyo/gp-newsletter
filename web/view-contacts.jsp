<jsp:include page="assets/header.jsp" flush="true" />


<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.loitsch.matthias.newsletter.Contact" %>
<%@ page import="com.loitsch.matthias.newsletter.PMF" %>
<%@ page import="com.loitsch.matthias.newsletter.utils.StringUtils" %>


<a href="/create-contact.jsp">Create contact</a>
<a href="/send-newsletter.jsp">Send newsletter</a>

<br /><br />

<%
      PersistenceManager pm = PMF.get().getPersistenceManager();
      String query = "select from " + Contact.class.getName() + " order by lastName range 0,5";
      List<Contact> contacts = (List<Contact>) pm.newQuery(query).execute();
      if (contacts.isEmpty()) {
%>
<p>There are no contacts.</p>
<%    } else {
%>

<ol>
  <%
              for (Contact c : contacts) {

  %>
  <li><b><a href="/view-contact.jsp?id=<%= c.getId()%>"><%= StringUtils.escapeHtml(c.getLastName())%> <%= StringUtils.escapeHtml(c.getFirstName())%>  &lt;<%= StringUtils.escapeHtml(c.getEmail())%>&gt;</a> <a class="error" href="/delete-contact?id=<%= c.getId()%>">Delete</a></b></li>
  <%
              }
  %>

</ol>
<%
      }
      pm.close();
%>

<jsp:include page="assets/footer.jsp" flush="true" />
