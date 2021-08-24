$(document).ready(function() {
    $('#content').summernote({
        height: 300
    });
});

let places = {
    init: function () {
        let _this = this;

        $('#placeSaveBtn').on('click', function () {
            _this.save();
        });
        $('#placeUpdateBtn').on('click', function () {
            _this.update();
        });
    },
    save: function () {
        let data = {
            title: $('#title').val(),
            content: $('#content').val()
        }

        $.ajax({
            type: 'POST',
            url: '/api/places',
            data: JSON.stringify(data),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = "/places";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update: function () {
        let id = $('#boardId').val();
        let data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'PUT',
            url: '/api/places/' + id,
            data: JSON.stringify(data),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert('수정이 완료되었습니다.');
            window.location.href = "/places/" + id
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
}

places.init();