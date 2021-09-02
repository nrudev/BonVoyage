let user = {
    init: function () {
        let _this = this;

        $('#userUpdateBtn').on('click', function () {
            _this.update();
        });
    },
    update: function () {
        let id = $('#userId').val();
        let password = $('#password').val();
        let nick = $('#nick').val().replaceAll(" ", "");

        let data = {
            password: password,
            nick: nick
        }

        if (password === null || password === "") {
            delete data[password];
        }

        $.ajax({
            type: 'PUT',
            url: '/api/user/update/' + id,
            data: JSON.stringify(data),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert('회원정보가 수정되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
}

user.init();