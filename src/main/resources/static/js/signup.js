let validationCheck = ["", "", false];

let signup = {
    init: function () {
        _this = this;

        $('#signupBtn').on('click', function () {
            _this.save();
        });
        $('#email').on('blur', function () {
            _this.emailNotBeEmptyOrChanged();
        });
        $('#emailValidateBtn').on('click', function () {
            _this.emailValidate();
        });
        $('#nick').on('blur', function () {
            _this.nickNotBeEmptyOrChanged();
        })
        $('#nickValidateBtn').on('click', function () {
            _this.nickValidate();
        });
        $('#pwdConfirm').on('blur', function () {
            _this.pwdConfirm();
        });
    },
    save: function () {
        let data = {
            email: $('#email').val(),
            nick: $('#nick').val(),
            password: $('#password').val()
        };

        if (data.email === "" || data.nick === "" || data.password === "") {
            alert('모든 항목을 작성해주셔야 합니다.');
        } else if (validationCheck[0] === "") {
            alert('이메일 중복확인이 필요합니다.');
        } else if (validationCheck[1] === "") {
            alert('닉네임 중복확인이 필요합니다.');
        } else if (validationCheck[2] !== true) {
            alert('비밀번호가 일치하지 않습니다.');
        } else {
            $.ajax({
                type: 'POST',
                url: '/api/user',
                data: JSON.stringify(data),
                dataType: 'json',
                contentType: 'application/json; charset=utf-8'
            }).done(function () {
                alert(`${data.nick}` + ' 님, 회원가입을 축하합니다.');
                window.location.href = "/";
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        }

    },
    emailNotBeEmptyOrChanged: function () {
        let email = $('#email').val();

        if (email === "" || email !== validationCheck[0]) {
            $('#emailValidateBtn').attr('disabled', false);
            validationCheck[0] = "";
        }
    },
    emailValidate: function () {
        let email = $('#email').val();
        let emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        // 이메일 양식 맞춤 필요
        if (email !== "" && email.match(emailRegExp) != null) {
            $.ajax({
                type: 'POST',
                url: '/api/user/emailCheck',
                data: email,
                dataType: 'json',
                contentType: 'application/json; charset=utf-8'
            }).done(function (data) {
                console.log(data);
                if (data) {
                    alert('사용 가능한 이메일입니다.');
                    $('#emailValidateBtn').attr('disabled', true);
                    validationCheck[0] = email;
                } else {
                    alert('이미 등록된 이메일입니다.');
                    $('#email').val('');
                    validationCheck[0] = "";
                }
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        } else if (email === "") {
            alert('이메일을 입력해주세요.');
        } else {
            alert('이메일 양식에 맞게 다시 작성해주세요.');
        }
    },
    nickNotBeEmptyOrChanged: function () {
        let nick = $('#nick').val();

        if (nick === "" || nick !== validationCheck[1]) {
            $('#nickValidateBtn').attr('disabled', false);
            validationCheck[1] = "";
        }
    },
    nickValidate: function () {
        let nick = $('#nick').val();

        $.ajax({
            type: 'POST',
            url: '/api/user/nickCheck',
            data: nick,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
        }).done(function (data) {
            if (data) {
                alert('사용 가능한 닉네임입니다.');
                $('#nickValidateBtn').attr('disabled', true);
                validationCheck[1] = nick;
            } else {
                alert('이미 사용중인 닉네임입니다.');
                $('#nick').val('');
                validationCheck[1] = "";
            }
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    pwdConfirm: function () {
        let password = $('#password').val();
        let pwdConfirm = $('#pwdConfirm').val();

        removeMsg();

        if (password === pwdConfirm) {
            $('div.form-group:nth-child(4)').append('<div class="checkMsg" style="color: blue"><small>비밀번호가 일치합니다.</small></div>');
            validationCheck[2] = true;
        } else {
            $('div.form-group:nth-child(4)').append('<div class="checkMsg" style="color: red"><small>비밀번호가 일치하지 않습니다.</small></div>');
            validationCheck[2] = false;
        }

        function removeMsg() {
            if ($('.checkMsg')) {
                $('.checkMsg').remove();
            }
        }
    }
}

signup.init();