<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
    <div class="page-title">
        <h1>여행지 수정 🌍</h1>
        <h3>내가 등록한 여행지를 수정합니다.</h3>
    </div>
    <hr/>
    <form>
        <input type="hidden" id="boardId" value="${place.id}" />
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" id="title" value="${place.title}" />
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea id="content" name="editordata">${place.content}</textarea>
        </div>
    </form>
    <div class="btn-list">
        <button type="button" class="btn btn-info" id="placeUpdateBtn">수정완료</button>
        <a href="/places" class="btn btn-danger" id="cancelUpdateBtn">취소</a>
    </div>
</div>

<script src="/js/places.js"></script>
<%@include file="../layout/footer.jsp"%>
