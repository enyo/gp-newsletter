<jsp:include page="assets/header.jsp" flush="true" />


<form action="create-contact" method="post">

  Title: <input name="title" /><br />
  First name: <input name="firstName" /><br />
  Middle name: <input name="middleName" /><br />
  Last name: <input name="lastName" /><br />
  E-mail: <input name="email" /><br />
  Note: <textarea  name="email"></textarea><br />
  <input type="submit" value="save" />
</form>

<jsp:include page="assets/footer.jsp" flush="true" />

