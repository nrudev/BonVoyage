$(document).ready(function () {
    $('#toAdminBtn').on('click', changeRole);
    $('#toUserBtn').on('click', changeRole);
    $('#userDelBtn').on('click', deleteUser);

    function changeRole() {
        let currentRow = $(this).closest("tr");
        let id = currentRow.find("td:eq(0)").text();
        let currentRole = currentRow.find("td:eq(3)").text();
        let newRole = {role: "ROLE_USER"};

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

    function deleteUser() {
        let currentRow = $(this).closest("tr");
        let id = currentRow.find("td:eq(0)").text();
        let nick = currentRow.find("td:eq(2)").text();

        $.ajax({
            type: 'DELETE',
            url: '/api/user/' + id,
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert(+ nick + " 님의 회원 탈퇴가 정상적으로 처리되었습니다.");
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
});