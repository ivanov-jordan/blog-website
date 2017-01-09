<%@ include file="includes/header.jsp" %>
<div class="wrapper row5">
<footer id="footer" class="clear" style="align: center;">
  <div style="width: 100%; text-align: center;">
	<div style="width: 300px; display: inline-block;">
      <h6 class="title">LOGIN</h6>
      <form:form cssClass="btmspace-50" modelAttribute="form" method="post">
	  <form:errors path="*" element="div" cssClass="error btmspace-15"/>
        <fieldset>
          <legend>Login:</legend>
          <form:input path="username" cssClass="btmspace-15" size="30" placeholder="Username" /> 
		  <form:password path="password" cssClass="btmspace-15" size="30" placeholder="Password" />
          <button type="submit" value="submit">Login</button>
        </fieldset>
      </form:form>
    </div>
  </div>
</footer>
</div>
<%@ include file="includes/footer.jsp" %>