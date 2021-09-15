<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Bon Voyage</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/places.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
<div class="wrap">
    <nav class="navbar navbar-expand-sm bg-info navbar-light">
        <a class="navbar-brand" href="/"><img src="/images/logo2.png" alt="logo"></a>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/places">Places</a>
            </li>
            <li class="nav-item">
                <sec:authorize access="isAnonymous()">
                    <a class="nav-link" href="/loginForm">Login</a>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <a class="nav-link" href="/admin/userList">UserList</a>
                    </li>
                    <li class="nav-item">
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                        <a class="nav-link" href="/user/${principal.user.id}">UserInfo</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                </sec:authorize>
            </li>
        </ul>
    </nav>
