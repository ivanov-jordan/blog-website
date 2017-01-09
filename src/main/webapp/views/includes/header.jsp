<%@ include file="taglibs.jsp" %><%--
 --%><%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%><!DOCTYPE html>
<html>
<head>
<title>Technology Blog</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/website/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
</head>
<body id="top">
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row0">
  <div id="topbar" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="fl_left">

    </div>
    <div class="fl_right">
      <ul class="nospace linklist">
      <c:choose>
        <c:when test="${user != null}">
        <li>Welcome, <c:out value="${user.username}" />!</li>
        <li><a href="/website/profile/logout">Log out</a></li>
        </c:when>
        <c:otherwise>
        <li><a href="/website/profile/login">Log in</a></li>
        <li><a href="/website/profile/register">Register</a></li>
        </c:otherwise>
      </c:choose>
      </ul>
    </div>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row1">
  <header id="header" class="clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1><a href="/website/">Technology Blog</a></h1>
    </div>
    <!-- ################################################################################################ -->
    <nav id="mainav" class="fl_right">
      <ul class="clear">
      <c:forEach items="${categoriesList}" var="category">
        <li><a href="/website/category/{$category.id}"><c:out value="${category.name}" /></a></li>
      </c:forEach>
      </ul>
    </nav>
    <!-- ################################################################################################ -->
  </header>
</div>
