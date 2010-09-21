<jsp:include page="assets/header.jsp" flush="true" />
<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.loitsch.matthias.newsletter.Contact" %>
<%@ page import="com.loitsch.matthias.newsletter.PMF" %>
<%@ page import="com.loitsch.matthias.newsletter.utils.StringUtils" %>



<%
      PersistenceManager pm = PMF.get().getPersistenceManager();

      Long contactId = Long.parseLong(request.getParameter("id"));

      Contact contact = pm.getObjectById(Contact.class, contactId);

%>


<a href="/view-contacts.jsp">View contacts</a>
<a class="error" href="/delete-contact?id=<%= contact.getId()%>">Delete</a><br /><br />


<form action="/update-contact" method="post">
  ID: <%= contact.getId()%><br />

  <input name="id" type="hidden" value="<%= contact.getId()%>" />
  Title: <input name="title" type="text" value="<%= StringUtils.escapeHtml(contact.getTitle())%>" /><br />
  First name: <input name="firstName" type="text" value="<%= StringUtils.escapeHtml(contact.getFirstName())%>" /><br />
  Middle name: <input name="middleName" type="text" value="<%= StringUtils.escapeHtml(contact.getMiddleName())%>" /><br />
  Last name: <input name="lastName" type="text" value="<%= StringUtils.escapeHtml(contact.getLastName())%>" /><br />
  Email: <input name="email" type="text" value="<%= StringUtils.escapeHtml(contact.getEmail())%>" /><br />
  Note: <textarea name="note"  name="email"><%= StringUtils.escapeHtml(contact.getNote())%></textarea><br />
  <input type="submit" value="Save!" />
</form>

<jsp:include page="assets/footer.jsp" flush="true" />

