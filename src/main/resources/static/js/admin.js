let admin = {
    init: function () {
        let _this = this;
        $('#toAdminBtn').on('click', function () {
            _this.changeRole();
        });
        $('#toUserBtn').on('click', function () {
            _this.changeRole();
        });
    },
    changeRole: function () {
        let currentRow = $(this).closest("tr");
        let id = currentRow.find("td:eq(0)").text();
        let role = "";

        if (currentRow.find("td:eq(3)") === "일반") {
            role = "ROLE_ADMIN";
        } else {
            role = "ROLE_USER";
        }

        console.log("id : " + id);
        console.log("role : " + role);

        $.ajax({
            type: 'PUT',
            url: '/api/admin/' + id,
            data: JSON.stringify(role),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert('회원 권한 변경이 정상적으로 처리되었습니다.');
            location.reload();
        }).fail(function (error) {
            console.log("role : " + role);
            alert(JSON.stringify(error));
        });
    }
}

// admin.init();