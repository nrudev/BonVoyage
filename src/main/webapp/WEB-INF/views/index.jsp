<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./layout/header.jsp"%>

<div class="container-fluid p-0">
    <div class="main-photo">
        <img src="/images/main.jpeg" alt="main">
        <h1>꼭 가보고 싶은<br/>여행지가 있나요?</h1>
        <h3>Bon Voyage에 기록해두세요!</h3>
        <a href="/places/save" class="btn btn-info">여행 장소 기록하기!</a>
    </div>
    <h3 class="top-ratings-title">⭐️ Places 조회수 TOP 4</h3>
    <div class="top-ratings">
        <c:choose>
            <c:when test="${empty tops}">
                    <h3>아직 게시물이 없어요! 게시물이 생기면 최고 조회수 게시물 4개를 여기에 보여드릴게요.</h3>
            </c:when>
            <c:otherwise>
                <c:forEach items="${tops}" var="top">
                    <div class="card top-ratings-places">
                        <div class="card-body">
                            <div class="top-ratings-places-title">
                                <a href="/places/${top.id}">${top.title}</a>
                            </div>
                            <div class="top-ratings-places-content">
                                <c:set var="content" value="${top.content}" />
                                <c:set var="contentSlice" value="${fn:substring(content, 0, 100)}" />
                                <c:set var="contentLength" value="${fn:length(content)}" />
                                <c:choose>
                                    <c:when test="${contentLength gt 100}">
                                        <p>${contentSlice} ...</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p>${contentSlice}</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<%@include file="./layout/footer.jsp"%>
