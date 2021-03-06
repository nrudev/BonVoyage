<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<div class="container">
    <div class="list-title">
        <h1>Places ๐</h1>
        <h3>๊ผญ ๊ฐ๋ณด๊ณ  ์ถ์ ์ฌํ์ง ๋ชฉ๋ก</h3>
    </div>
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>์ ๋ชฉ</th>
            <th>์์ฑ์</th>
            <th>์กฐํ์</th>
            <th>๋ฑ๋ก์ผ</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${places.content}" var="place">
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
    <sec:authorize access="isAuthenticated()">
        <a href="/places/save" class="btn btn-info">๊ธ์ฐ๊ธฐ</a>
    </sec:authorize>
    <div class="text-xs-center">
        <ul class="pagination justify-content-center">
            <!-- ์ด์  -->
            <c:choose>
                <c:when test="${places.first}"></c:when>
                <c:otherwise>
                    <li class="page-item"><a href="/places?page=0" class="page-link">&laquo;</a></li>
                    <li class="page-item"><a href="/places?page=${places.number-1}" class="page-link">&lt;</a></li>
                </c:otherwise>
            </c:choose>
            <!-- ํ์ด์ง ๋ฒํธ -->
            <c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
                <c:choose>
                    <c:when test="${places.pageable.pageNumber + 1 == i}">
                        <li class="page-item disabled"><a href="/places?page=${i-1}" class="page-link">${i}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a href="/places?page=${i-1}" class="page-link">${i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <!-- ๋ค์ -->
            <c:choose>
                <c:when test="${places.last}"></c:when>
                <c:otherwise>
                    <li class="page-item"><a href="/places?page=${places.number+1}" class="page-link">&gt;</a></li>
                    <li class="page-item"><a href="/places?page=${places.totalPages-1}" class="page-link">&raquo;</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>
<%@include file="../layout/footer.jsp"%>
