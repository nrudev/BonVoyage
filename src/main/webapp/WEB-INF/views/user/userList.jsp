<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
    <div class="list-title">
        <h1>νμ κ΄λ¦¬ π§βπ»</h1>
    </div>
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>μ΄λ©μΌ</th>
            <th>λλ€μ</th>
            <th>νμκΆν</th>
            <th>κ°μμΌ</th>
            <th>κΆνλ³κ²½</th>
            <th>κΈ°ν</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users.content}" var="user">
            <tr>
                <td class="userId">${user.id}</td>
                <td>${user.email}</td>
                <td>${user.nick}</td>
                <c:choose>
                    <c:when test="${user.role eq 'ROLE_USER'}">
                        <td class="role">μΌλ°</td>
                    </c:when>
                    <c:otherwise>
                        <td class="role">κ΄λ¦¬μ</td>
                    </c:otherwise>
                </c:choose>
                <td>${user.createdDate}</td>
                <c:choose>
                    <c:when test="${user.role eq 'ROLE_USER'}">
                        <td><button class="btn btn-info" id="toAdminBtn">κ΄λ¦¬μλ‘ λ±λ‘</button></td>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${user.email ne principal.user.email}">
                            <td><button class="btn btn-warning" id="toUserBtn">μΌλ°νμμΌλ‘ μ ν</button></td>
                        </c:if>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${user.email ne principal.user.email}">
                        <td><button class="btn btn-danger" id="userDelBtn">νμ νν΄</button></td>
                    </c:when>
                    <c:otherwise>
                        <td></td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="text-xs-center">
        <ul class="pagination justify-content-center">
            <!-- μ΄μ  -->
            <c:choose>
                <c:when test="${users.first}"></c:when>
                <c:otherwise>
                    <li class="page-item"><a href="/admin/userList?page=0" class="page-link">&laquo;</a></li>
                    <li class="page-item"><a href="/admin/userList?page=${users.number-1}" class="page-link">&lt;</a></li>
                </c:otherwise>
            </c:choose>
            <!-- νμ΄μ§ λ²νΈ -->
            <c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
                <c:choose>
                    <c:when test="${users.pageable.pageNumber + 1 == i}">
                        <li class="page-item disabled"><a href="/admin/userList?page=${i-1}" class="page-link">${i}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a href="/admin/userList?page=${i-1}" class="page-link">${i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <!-- λ€μ -->
            <c:choose>
                <c:when test="${users.last}"></c:when>
                <c:otherwise>
                    <li class="page-item"><a href="/admin/userList?page=${users.number+1}" class="page-link">&gt;</a></li>
                    <li class="page-item"><a href="/admin/userList?page=${users.totalPages-1}" class="page-link">&raquo;</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>

<script src="/js/admin.js"></script>
<%@include file="../layout/footer.jsp"%>