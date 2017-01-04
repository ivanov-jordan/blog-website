<%@ include file="includes/taglibs.jsp" %>
Registration:<br/>
	<form:form modelAttribute="form" method="post">
		<div class=row>
			<form:errors path="*" element="span" cssClass="redcolor"/>&nbsp;
		</div>
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
