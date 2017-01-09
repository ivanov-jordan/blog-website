<%@ include file="includes/header.jsp" %>
<div class="wrapper row5">
<footer id="footer" class="clear" style="align: center;">
  <div style="width: 100%; text-align: center;">
	<div style="width: 300px; display: inline-block;">
      <h6 class="title">REGISTRATION</h6>
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

<%@ include file="includes/taglibs.jsp" %>
Registration:<br/>
	<form:form modelAttribute="form" method="post">
			<br class="clear" /><br />
       	<div class="row">
       		<label class="usual-label">Username : </label>
       		<form:input path="username" cssClass="textfield" />
       		<form:errors path="username" element="span" cssClass="redcolor"/>
   		</div>
   		<div class="row">
       		<label class="usual-label">First name : </label>
       		<form:input path="firstname" cssClass="textfield" />
       		<form:errors path="firstname" element="span" cssClass="redcolor"/>
   		</div>
   		<div class="row">
       		<label class="usual-label">Last name : </label>
       		<form:input path="lastname" cssClass="textfield" />
       		<form:errors path="lastname" element="span" cssClass="redcolor"/>
   		</div>
   		<div class="row">
       		<label class="usual-label">Email : </label>
       		<form:input path="email" cssClass="textfield" />
       		<form:errors path="email" element="span" cssClass="redcolor"/>
   		</div>
		<div class="row">
			<label class="usual-label">Password : </label>
			<form:password path="password" cssClass="textfield" />
			<form:errors path="password" element="span" cssClass="redcolor"/>
		</div>
		<div class="row">
			<label class="usual-label">Confirm password : </label>
			<form:password path="confirmPassword" cssClass="textfield" />
			<form:errors path="confirmPassword" element="span" cssClass="redcolor"/>
		</div>
		<br class="clear" /><br />
		<div class="row">
			<label class="usual-label">&nbsp;</label>
			<input type="submit" value="Register" class="makebutton" />
		</div>
	</form:form>
