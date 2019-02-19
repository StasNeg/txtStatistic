var basicUrl = 'http://localhost:8080';
var idFile;
var tableStatistic;

$(document).ready(function () {
    tableStatistic = null;
    $.ajax({
        'type': 'GET',
        'url': basicUrl + "/files",
        'contentType': 'application/json',
        'success': function (data, status) {
            createFilesTable(data)
        },
        'error': function (xhr, status) {
            alert(xhr.responseJSON.message);
        }
    });


});

$('#showStatistic').on('shown.bs.modal', function (e) {
    $.ajax({
        'type': 'GET',
        'url': basicUrl + "/files/statistic/" + idFile,
        'contentType': 'application/json',
        'success': function (data) {

            if (tableStatistic === null)
                createStatisticTable(data);
            else
                tableStatistic.rows.add(data).draw();
        },
        'error': function (xhr, status) {
            alert(xhr.responseJSON.message);
        }
    });
});

function createFilesTable(files) {
    var table = $('#fileTable').DataTable({
            data: files,
            "columns": [
                {
                    "data": "id",
                    "visible": false
                },
                {
                    title: "Name of file",
                    "data": "name"
                },

                {
                    title: "Statistics",
                    "targets": -1,
                    "data": null,
                    "defaultContent": '<button type="button" name = "btnStatistic" class="btn btn-primary btn-xs" data-title="Edit" ' +
                        'data-toggle="modal" data-target="#showStatistic"> ' +
                        '<span class="glyphicon glyphicon-pencil"></span> ' +
                        '</button>'
                }
            ]
        }
    );
    $('#fileTable tbody').on('click', '[name= "btnStatistic"]', function () {
        var data = table.row($(this).parents('tr')).data();
        idFile = data.id;
    });
}

function createStatisticTable(fileStatistic) {
    tableStatistic = $('#fileTableStatistic').DataTable({
            data: fileStatistic,
            "columns": [
                {
                    "data": "id",
                    "visible": false
                },
                {
                    title: "Line number",
                    "data": "lineNumber"
                },
                {
                    title: "Longest word",
                    "data": "longestWord"
                },
                {
                    title: "Shortest word",
                    "data": "shortersWord"
                },
                {
                    title: "Line length",
                    "data": "length"
                },
                {
                    title: "Average Word Length",
                    "data": "averageWordLength"
                }
            ]
        }
    );
}

$('#showStatistic').on('hidden.bs.modal', function () {
    tableStatistic.clear();
})