<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>이메일</th>
            <th>닉네임</th>
            <th>회원권한</th>
            <th>가입일</th>
            <th>권한변경</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td class="userId">${user.id}</td>
                <td>${user.email}</td>
                <td>${user.nick}</td>
                <c:choose>
                    <c:when test="${user.role eq 'ROLE_USER'}">
                        <td class="role">일반</td>
                    </c:when>
                    <c:otherwise>
                        <td class="role">관리자</td>
                    </c:otherwise>
                </c:choose>
                <td>${user.createdDate}</td>
                <c:choose>
                    <c:when test="${user.role eq 'ROLE_USER'}">
                        <td><button class="btn btn-info" id="toAdminBtn">관리자로 등록</button></td>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${user.email ne principal.user.email}">
                            <td><button class="btn btn-warning" id="toUserBtn">일반회원으로 전환</button></td>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    $(document).ready(function () {
        $('#toAdminBtn').on('click', changeRole);
        $('#toUserBtn').on('click', changeRole);

        function changeRole() {
            let currentRow = $(this).closest("tr");
            let id = currentRow.find("td:eq(0)").text();
            let currentRole = currentRow.find("td:eq(3)").text();
            let newRole = { role : "ROLE_USER" };

            if (currentRole === "일반") {
                newRole.role = "ROLE_ADMIN";
            }

            console.log("id : " + id);
            console.log(JSON.stringify(newRole));

            $.ajax({
                type: 'PUT',
                url: '/api/admin/' + id,
                data: JSON.stringify(newRole),
                dataType: 'json',
                contentType: 'application/json; charset=utf-8'
            }).done(function () {
                alert('회원 권한 변경이 정상적으로 처리되었습니다.');
                location.reload();
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        }
    })
</script>
<%--<script src="/js/admin.js"></script>--%>
<%@include file="../layout/footer.jsp"%>