<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
    <div class="page-title">
        <h1>여행지 등록 🌍</h1>
        <h3>여행지를 등록하여 사람들과 공유합니다.</h3>
    </div>
    <hr/>
    <form>
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" id="title">
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea id="content" name="editordata"></textarea>
        </div>
    </form>
    <div class="btn-list">
        <button class="btn btn-info" id="placeSaveBtn">등록</button>
        <a href="/places" class="btn btn-danger" id="cancelSaveBtn">취소</a>
    </div>
</div>

<script src="/js/places.js"></script>
<%@include file="../layout/footer.jsp"%>
