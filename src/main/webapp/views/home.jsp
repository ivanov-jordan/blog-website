<%@ include file="includes/header.jsp" %>
<div class="wrapper row4">
  <section id="cta" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="center btmspace-50">
      <h2 class="nospace">Latest news from the technology sector</h2>
      <p class="nospace">Trends, news, reviews and other useful information</p>
    </div>
    <div class="group">
    <c:forEach items="${articles}" var="article" begin="0" end="1" varStatus="loop">
      <div class="colour-${loop.index+1} one_half <c:if test="${loop.index == 0}">first</c:if>">
        <article class="group colour-${loop.index+1}"> 
          <!-- ################################################################################################ -->
          <div class="one_half first"><img src="${article.image}" alt="" style="width: 320px; height: 150px;"></div>
          <div class="one_half">
            <h6 class="heading"><c:out value="${article.title}" /></h6>
            <p class="link"><a class="btn" href="#">Read More &raquo;</a></p>
          </div>
          <!-- ################################################################################################ -->
        </article>
      </div>
    </c:forEach>
    </div>
    <!-- ################################################################################################ -->
    <div class="clear"></div>
  </section>
</div>

<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body -->
    <!-- ################################################################################################ -->
    <div class="group">
      <div>
        <ul id="latestposts" class="nospace">
        <c:forEach items="${articles}" var="article" begin="2">
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
              <p class="link"><a class="btn" href="#">Read More &raquo;</a></p>
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


<c:forEach items="${articles}" var="article" begin="2">
  <c:out value="${article.title}"/><br/><br/>
</c:forEach>
<%@ include file="includes/footer.jsp" %>