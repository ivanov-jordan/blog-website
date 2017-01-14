<%@ include file="includes/header.jsp" %>

<div class="wrapper row4">
  <main class="container clear"> 
    <!-- main body -->
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <form:form modelAttribute="categoryForm" method="post">
        <form:errors path="*" element="div" cssClass="error btmspace-15"/>
        <form:hidden path="id"/>
        <div class="block clear">
            <label for="name">Category name <span>*</span></label>
            <form:input path="name" id="name" size="100" />
            <input name="submit" type="submit" value="Save">
          </div>
        </form:form>      
        
        <form onsubmit="return confirm('Do you really want to delete this category?');" action="./delete" method="post">
        	<input name="delete" type="submit" value="Delete">
        </form>
        
      </div>

    <!-- ################################################################################################ -->
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>


<%@ include file="includes/footer.jsp" %>