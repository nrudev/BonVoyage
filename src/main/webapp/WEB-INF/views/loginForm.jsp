<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./layout/header.jsp"%>

<div class="card">
    <div class="card-header">LOGIN</div>
    <div class="card-body">
        <div class="form-group">
            <label for="username">이메일</label>
            <input type="email" class="form-control" id="username" />
        </div>
        <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" class="form-control" id="password" />
        </div>
        <div class="form-check">
            <label for="remember" class="form-check-label">
                <input type="checkbox" class="form-check-input" id="remember" />Remember Me
            </label>
        </div>
        <a href="/signup">아직 회원이 아니신가요?</a>
    </div>
    <div class="card-footer">
        <button class="btn btn-info" id="loginBtn">로그인</button>
    </div>
</div>

<%@include file="./layout/footer.jsp"%>