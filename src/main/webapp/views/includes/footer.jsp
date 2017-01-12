<div class="wrapper row5">
  <footer id="footer" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="one_half first">
      <h6 class="title">About this blog</h6>
      <p class="nospace btmspace-30">The technology blog website was created exclusively for the course Developing 
      quality software and systems II, Software Engineering, Varna University of Management.</p>
      <ul class="nospace">
        <li class="btmspace-10">
          <address>
          <span class="fa fa-map-marker"></span> Jordan Ivanov
          </address>
        </li>
        <li class="btmspace-10"><span class="fa fa-phone"></span> +359 896 608330</li>
        <li><span class="fa fa-envelope-o"></span> jordan.ivanov@gmail.com</li>
      </ul>
    </div>
    <div class="one_quarter">
      <h6 class="title">Quick Links</h6>
      <ul class="nospace linklist">
        <li><a href="/website/">Home Page</a></li>
        <c:forEach items="${categoriesList}" var="category">
        <li><a href="/website/category/${category.id}"><c:out value="${category.name}"/></a></li>
        </c:forEach>
        <li><a href="/website/contacts">Contact Us</a></li>
      </ul>
    </div>
    <div class="one_quarter">
      <h6 class="title">Keep in Touch</h6>
      <form class="btmspace-50" method="post" action="#">
        <fieldset>
          <legend>Newsletter:</legend>
          <input class="btmspace-15" type="text" value="" placeholder="Email">
          <button type="submit" value="submit">Submit</button>
        </fieldset>
      </form>
      <ul class="faico clear">
        <li><a class="faicon-facebook" href="#"><i class="fa fa-facebook"></i></a></li>
        <li><a class="faicon-pinterest" href="#"><i class="fa fa-pinterest"></i></a></li>
        <li><a class="faicon-twitter" href="#"><i class="fa fa-twitter"></i></a></li>
        <li><a class="faicon-dribble" href="#"><i class="fa fa-dribbble"></i></a></li>
        <li><a class="faicon-linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
        <li><a class="faicon-google-plus" href="#"><i class="fa fa-google-plus"></i></a></li>
        <li><a class="faicon-rss" href="#"><i class="fa fa-rss"></i></a></li>
      </ul>
    </div>
    <!-- ################################################################################################ -->
  </footer>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row6">
  <div id="copyright" class="clear"> 
    <!-- ################################################################################################ -->
    <p class="fl_left">Copyright &copy; 2017 - All Rights Reserved - <a href="#">The Technology Blog</a></p>
    <p class="fl_right">Template by <a target="_blank" href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- JAVASCRIPTS -->
<div id="commonDialog"></div>
<script src="/website/layout/scripts/jquery.min.js"></script> 
<script src="/website/layout/scripts/jquery.mobilemenu.js"></script>
<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
<script>tinymce.init({ selector:'textarea.tinymce' });</script>
</body>
</html>