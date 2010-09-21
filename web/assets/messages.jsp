<%
      String errorMessage = request.getParameter("error");

      if (errorMessage != null) {
%>
<h1 class="error"><%= errorMessage%></h1>
<%
      }
%>


<%
      String successMessage = request.getParameter("success");

      if (successMessage != null) {
%>
<h1 class="success"><%= successMessage%></h1>
<%
      }
%>