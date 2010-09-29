<jsp:include page="assets/header.jsp" flush="true" />

<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.loitsch.matthias.newsletter.entities.Contact" %>
<%@ page import="com.loitsch.matthias.newsletter.entities.Address" %>
<%@ page import="com.loitsch.matthias.newsletter.entities.PhoneNumber" %>
<%@ page import="com.loitsch.matthias.newsletter.PMF" %>
<%@ page import="com.loitsch.matthias.newsletter.utils.StringUtils" %>
<%@ page import="com.google.appengine.api.datastore.Key" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>



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
  Title: <input name="title" type="text" value="<%= contact.getTitle() == null ? "" : StringUtils.escapeHtml(contact.getTitle())%>" /><br />
  First name: <input name="firstName" type="text" value="<%= contact.getFirstName() == null ? "" : StringUtils.escapeHtml(contact.getFirstName())%>" /><br />
  Middle name: <input name="middleName" type="text" value="<%= contact.getMiddleName() == null ? "" : StringUtils.escapeHtml(contact.getMiddleName())%>" /><br />
  Last name: <input name="lastName" type="text" value="<%= contact.getLastName() == null ? "" : StringUtils.escapeHtml(contact.getLastName())%>" /><br />
  Email: <input name="email" type="text" value="<%= contact.getEmail() == null ? "" : StringUtils.escapeHtml(contact.getEmail())%>" /><br />
  Note: <textarea name="note" cols="10" rows="3"><%= contact.getNote() == null ? "" : StringUtils.escapeHtml(contact.getNote())%></textarea><br />
  <input type="submit" value="Save!" />
</form>


<h2>Existing phone numbers</h2>

<%



      if (!contact.getPhoneNumbers().isEmpty()) {
        for (PhoneNumber phoneNumber : contact.getPhoneNumbers()) {

%>
<div class="phone-number">
  <a class="error" href="/delete-phone-number?id=<%= KeyFactory.keyToString(phoneNumber.getId())%>">Delete</a><br />
  <%= phoneNumber.getNumber() == null ? "" : StringUtils.escapeHtml(phoneNumber.getNumber())%><br /><br />
</div>
<%        }
      }
%>



<form action="/create-phone-number" method="post">
  <h1>Add a phone number</h1>

  <input name="contactId" type="hidden" value="<%= contact.getId()%>" />

  Number: <input name="number" type="text" value="" /><br />

  <input type="submit" value="Add!" />
</form>





<h2>Existing addresses</h2>

<%



      if (!contact.getAddresses().isEmpty()) {
        for (Address address : contact.getAddresses()) {

%>
<div class="address">
  <a class="error" href="/delete-address?id=<%= KeyFactory.keyToString(address.getId())%>">Delete</a><br />
  <%= address.getStreet() == null ? "" : StringUtils.escapeHtml(address.getStreet(), true)%><br />
  <%= address.getZipCode()%> - <%= address.getCity() == null ? "" : StringUtils.escapeHtml(address.getCity())%><br />
  <%= address.getCountry() == null ? "" : StringUtils.escapeHtml(address.getCountry())%><br /><br />
</div>
<%        }
      }
%>


<form action="/create-address" method="post">
  <h1>Add an address</h1>

  <input name="contactId" type="hidden" value="<%= contact.getId()%>" />

  Street: <textarea name="street" cols="10" rows="3"></textarea><br />
  City: <input name="city" type="text" value="" /><br />
  Country: <input name="country" type="text" value="Österreich" /><br />
  Zip Code: <input name="zipCode" type="text" value="" /><br />

  <input type="submit" value="Add!" />
</form>

<jsp:include page="assets/footer.jsp" flush="true" />

