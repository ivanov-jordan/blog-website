<%@ include file="includes/header.jsp" %>
<div class="wrapper row5">
<footer id="footer" class="clear" style="align: center;">
  <div style="width: 100%; text-align: center;">
	<div style="width: 300px; display: inline-block;">
      <h6 class="title">REGISTRATION</h6>
      <form:form cssClass="btmspace-50" modelAttribute="form" method="post">

	  <form:input path="username" cssClass="btmspace-15" size="40" placeholder="Username" />
      <form:errors path="username" element="span" cssClass="imgl error"/>
      
      <form:input path="firstname" cssClass="btmspace-15" size="40" placeholder="First name" />
      <form:errors path="firstname" element="span" cssClass="imgl error"/>
      
      <form:input path="lastname" cssClass="btmspace-15" size="40" placeholder="Last name" />
      <form:errors path="lastname" element="span" cssClass="imgl error"/>
      
      <form:input path="email" cssClass="btmspace-15" size="40" placeholder="Email" />
      <form:errors path="email" element="span" cssClass="imgl error"/>
       
      <form:password path="password" cssClass="btmspace-15" size="40" placeholder="Password" />
      <form:errors path="password" element="span" cssClass="imgl error"/>
      
      <form:password path="confirmPassword" cssClass="btmspace-15" size="40" placeholder="Confirm Password" />
      <form:errors path="confirmPassword" element="span" cssClass="imgl error"/>
      
      <button type="submit" value="submit">Register</button>

      </form:form>
    </div>
  </div>
</footer>
</div>
<%@ include file="includes/footer.jsp" %>