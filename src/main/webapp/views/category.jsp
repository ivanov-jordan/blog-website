<%@ include file="includes/header.jsp" %>

<div class="wrapper row4">
  <main class="container clear"> 
    <!-- main body -->
    <!-- ################################################################################################ -->
    <div class="group">
      <div>
        <ul id="latestposts" class="nospace">
        <c:forEach items="${articles}" var="article">
          <li class="clear">
            <figure class="one_quarter first"><img class="borderedbox inspace-5" src="${article.image}" alt="" style="width: 120px; height: 120px;"></figure>
            <article class="three_quarter">
              <h2 class="heading"><c:out value="${article.title}" /></h2>
              <div class="meta">
                <address>
                By <a href="#"><c:out value="${article.author.firstname}" /> <c:out value="${article.author.lastname}" /></a>
                </address>
                <time datetime="${article.published}"><c:out value="${article.published}" /></time>
              </div>
              <p class="shortintro"><c:out value="${article.description}" /></p>
              <p class="link"><a class="btn" href="/website/article/${article.id}">Read More &raquo;</a></p>
            </article>
          </li>
          </c:forEach>
        </ul>
      </div>
    </div>
    <!-- ################################################################################################ -->
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>

<%@ include file="includes/footer.jsp" %>