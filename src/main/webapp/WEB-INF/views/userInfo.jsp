<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./layout/header.jsp"%>
<link rel="stylesheet" href="/css/userInfo.css">

<div class="card">
    <div class="card-header">회원정보</div>
    <form>
        <input type="hidden" id="userId" value="${principal.user.id}" />
        <div class="card-body">
            <div class="form-group">
                <label for="email">이메일</label>
                <input type="email" class="form-control" id="email" value="${principal.user.email}" readonly />
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" class="form-control" id="password" name="password" />
            </div>
            <div class="form-group">
                <label for="nick">닉네임</label>
                <input type="text" class="form-control" id="nick" name="nick" value="${principal.user.nick}" />
                <button type="button" class="btn btn-outline-danger" id="nickUpdValidateBtn" disabled>중복확인</button>
            </div>
        </div>
        <div class="card-footer">
            <button type="button" class="btn btn-info form-control" id="userUpdateBtn">수정완료</button>
        </div>
    </form>
</div>

<script src="/js/user.js"></script>
<%@include file="./layout/footer.jsp"%>