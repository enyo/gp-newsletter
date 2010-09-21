<jsp:include page="assets/header.jsp" flush="true" />


<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.loitsch.matthias.newsletter.utils.StringUtils" %>


<a href="/view-contacts.jsp">View contacts</a><br /><Br />

<form action="/send-newsletter" method="post">
  Subject: <input type="text" name="subject" value="" /><br />
  Message: <textarea name="message"></textarea>

  <input type="submit" value="Send newsletter" />
</form>

<jsp:include page="assets/footer.jsp" flush="true" />
