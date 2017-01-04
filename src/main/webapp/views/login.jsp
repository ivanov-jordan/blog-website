<%@ include file="includes/taglibs.jsp" %>
Login:<br/>
	<form:form modelAttribute="form" method="post">
		<div class=row>
			<form:errors path="*" element="span" cssClass="redcolor"/>&nbsp;
		</div>
			<br class="clear" /><br />
       	<div class="row">
       		<label class="usual-label">User : </label>
       		<form:input path="username" cssClass="textfield" />
   		</div>
   		<br class="clear" /><br />
		<div class="row">
			<label class="usual-label">Password : </label>
			<form:password path="password" cssClass="textfield" />
		</div>
		<br class="clear" /><br />
		<div class="row">
			<label class="usual-label">&nbsp;</label>
			<input type="submit" value="Login" class="makebutton" />
		</div>
	</form:form>
