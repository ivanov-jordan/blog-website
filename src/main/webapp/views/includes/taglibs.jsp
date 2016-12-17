<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>

<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>

<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"	uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="timeZone" value="GMT" />
<c:set var="dateFormat" value="dd/MM/yyyy HH:mm:ss:SSS Z" />
