<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./layout/header.jsp"%>

<link rel="stylesheet" href="/css/signup.css">

<div class="card">
    <div class="card-header">SIGNUP</div>
    <form class="card-body">
        <div class="form-group">
            <label for="email">이메일</label>
            <input type="email" class="form-control" id="email" placeholder="이메일을 입력하세요" />
            <button class="btn btn-outline-danger" id="emailValidateBtn">중복확인</button>
        </div>
        <div class="form-group">
            <label for="nick">닉네임</label>
            <input type="text" class="form-control" id="nick" placeholder="닉네임을 입력하세요" />
            <button class="btn btn-outline-danger" id="nickValidateBtn">중복확인</button>
        </div>
        <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력하세요" />
        </div>
        <div class="form-group">
            <label for="pwdConfirm">비밀번호 확인</label>
            <input type="password" class="form-control" id="pwdConfirm" placeholder="비밀번호를 한번 더 입력하세요" />
        </div>
    </form>
    <div class="card-footer">
        <button class="btn btn-info" id="signupBtn">회원가입</button>
    </div>
</div>

<%@include file="./layout/footer.jsp"%>