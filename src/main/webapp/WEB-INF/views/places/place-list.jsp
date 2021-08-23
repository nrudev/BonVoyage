<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<div class="container">
    <div class="list-title">
        <h1>Places 🌏</h1>
        <h3>꼭 가보고 싶은 여행지 목록</h3>
    </div>
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>등록일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${places}" var="place">
            <tr>
                <td>${place.id}</td>
                <td><a href="/places/${place.id}">${place.title}</a></td>
                <td>${place.user.nick}</td>
                <td>${place.count}</td>
                <td>${place.createdDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/places/save" class="btn btn-info">글쓰기</a>
</div>
<%@include file="../layout/footer.jsp"%>
