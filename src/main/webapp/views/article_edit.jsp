<%@ include file="includes/header.jsp" %>

<div class="wrapper row4">
  <main class="container clear"> 
    <!-- main body -->
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <form:form modelAttribute="articleForm" method="post">
        <form:errors path="*" element="div" cssClass="error btmspace-15"/>
        <form:hidden path="id"/>
        <div class="block clear">
            <label for="name">Title <span>*</span></label>
            <form:input path="title" id="name" size="100" />
          </div>
          <div class="block clear">
            <label for="image">Image URL <span>*</span></label>
            <form:input path="image" id="image" size="100" />
          </div>
          <div class="block clear">
            <label for="description">Description <span>*</span></label>
            <form:input path="description" id="description" size="100" />
          </div>
          <div class="block clear">
            <label for="content">Content</label>
            <form:textarea path="content" id="content" cssClass="tinymce" cols="25" rows="10"></form:textarea>
          </div>
          <div class="block clear">
            <label for="content">Categories</label>
            <form:select path="categories" multiple="multiple" items="${categoriesList}" itemLabel="name" itemValue="id" />
          </div>
          <div>
            <input name="submit" type="submit" value="Save">
          </div>
        </form:form>      
        
      </div>
      <!-- ################################################################################################ -->
    </div>
    <!-- ################################################################################################ -->
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>


<%@ include file="includes/footer.jsp" %>