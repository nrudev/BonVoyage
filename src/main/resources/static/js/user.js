const firstNick = $('#nick').val();
let nickValidation = firstNick;

let user = {
    init: function () {
        let _this = this;

        $('#userUpdateBtn').on('click', function () {
            _this.update();
        });
        $('#nick').on('blur', function () {
            _this.activateValidationBtn();
        });
        $('#nickUpdValidateBtn').on('click', function () {
            _this.nickValidation();
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
        if (!$('#nickUpdValidateBtn').attr('disabled')) {
            alert('닉네임 중복확인이 필요합니다.');
        } else if (nickValidation === firstNick && (password === "" || password === null)) {
            alert('수정할 내용이 없습니다.');
        } else {
            $.ajax({
                type: 'PUT',
                url: '/api/user/update/' + id,
                data: JSON.stringify(data),
                dataType: 'json',
                contentType: 'application/json; charset=utf-8'
            }).done(function () {
                alert('회원정보가 수정되었습니다. 다시 로그인해주세요.');
                window.location.href = "/logout";
            }).fail(function (error) {
                console.log(JSON.stringify(error));
            });
        }
    },
    activateValidationBtn: function () {
        let nick = $('#nick').val().replaceAll(" ", "");

        if (nick !== firstNick) {
            $('#nickUpdValidateBtn').attr('disabled', false);
        } else {
            $('#nickUpdValidateBtn').attr('disabled', true);
        }
    },
    nickValidation: function () {
        let nick = $('#nick').val().replaceAll(" ", "");

        if (nick === "" || nick === null) {
            alert('변경하실 닉네임을 입력해주세요.');
        } else {
            $.ajax({
                type: 'POST',
                url: '/api/user/nickCheck',
                data: nick,
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
            }).done(function (data) {
                if (data) {
                    alert('사용 가능한 닉네임입니다.');
                    $('#nickUpdValidateBtn').attr('disabled', true);
                    $('#nick').val(nick);
                    nickValidation = nick;
                } else {
                    alert('이미 사용중인 닉네임입니다.');
                    $('#nick').val('');
                    nickValidation = firstNick;
                }
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        }
    }
}

user.init();