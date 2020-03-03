<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
%>
<html lang="en">
<head>
  <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <title>聚盟单点登录系统登录页面</title>
  	<spring:theme code="standard.custom.css.file" var="customCssFile" />
    <link rel="stylesheet" href="<c:url value="${customCssFile}" />" />
    <link rel="stylesheet" href="<c:url value="/css/main.css" />" />
    <script type="text/javascript" src="<c:url value="/js/jquery-1.7.1.js"/>"></script>
    <link rel="icon" href="<c:url value="/favicon.ico" />" type="image/x-icon" />
	<!--[if lt IE 9]>
		<script src="/js/html5shiv.js" type="text/javascript"></script>
	<![endif]-->
</head>
<body style="min-width:980px;overflow: hidden; min-height:575px;">
<div class="header">
	<img src="<c:url value="/images/logo.png" />" alt="Logo" width="100"/>
	<span>伯乐物流信息科技平台</span>
</div>
