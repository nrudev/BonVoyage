<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
    <div class="card">
        <div class="card-header place-infos">
            <div class="place-title">${place.title}</div>
            <div class="place-info">
                <small class="place-count">조회수 : ${place.count}</small><br/>
                <small class="place-createdDate">작성일 : ${place.createdDate}</small>
            </div>
        </div>
        <div class="card-body place-body">
            <div class="place-content">${place.content}</div>
        </div>
        <div class="card-footer">
            <a href="/places" class="btn btn-secondary">목록</a>
            <c:if test="${place.user.id == principal.user.id}">
                <button class="btn btn-warning" id="placeUpdateBtn">수정</button>
                <button class="btn btn-danger" id="placeDelBtn">삭제</button>
            </c:if>
        </div>
    </div>
</div>

<script src="/js/places.js"></script>
<%@include file="../layout/footer.jsp"%>