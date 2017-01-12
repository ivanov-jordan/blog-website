<%@ include file="includes/header.jsp" %>

<div class="wrapper row4">
  <main class="container clear"> 
    <!-- main body -->
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <h1><c:out value="${article.title}" /></h1>
      <div class="meta btmspace-50">
                <address>
                By <a href="#"><c:out value="${article.author.firstname}" /> <c:out value="${article.author.lastname}" /></a>
                </address>
                <time datetime="${article.published}"><c:out value="${article.published}" /></time>
      </div>
      <img class="imgr borderedbox inspace-5" src="${article.image}" alt="" style="width: 460px; height: 300px;">
      
      <c:out value="${article.content}" escapeXml="false" />
      
      <div id="comments">
      <c:choose>
      <c:when test="${fn:length(comments) <= 0}">
      <h2>No comments yet</h2>
      </c:when>
      <c:otherwise>
      <h2>Comments</h2>
        <ul>
      <c:forEach items="${comments}" var="comment">
          <li>
            <article>
              <header>
                <figure class="avatar"><img src="../images/demo/avatar.png" alt=""></figure>
                <address>
                By <a href="#"><c:out value="${comment.user.firstname}" /> <c:out value="${comment.user.lastname}" /></a>
                </address>
                <time datetime="${comment.published}"><c:out value="${comment.published}" /></time>
              </header>
              <div class="comcont">
                <p><c:out value="${comment.comment}" /></p>
              </div>
            </article>
          </li>      
      </c:forEach>
        </ul>
      </c:otherwise>
      </c:choose>
        

        <h2>Write A Comment</h2>
      <c:choose>
      <c:when test="${user == null}">
      <div>You must be logged in order to leave a comment.</div>
      </c:when>
      <c:otherwise>
        <form:form action="./${article.id}/comment" modelAttribute="commentForm" method="post">
        <form:errors path="*" element="div" cssClass="error btmspace-15"/>
            <label for="comment">Your Comment</label>
            <form:textarea path="comment" id="comment" cols="25" rows="10"></form:textarea>
          </div>
          <div>
            <input name="submit" type="submit" value="Submit">
          </div>
        </form:form>
      </c:otherwise>
      </c:choose>
        
      </div>
      <!-- ################################################################################################ -->
    </div>
    <!-- ################################################################################################ -->
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>


<%@ include file="includes/footer.jsp" %>