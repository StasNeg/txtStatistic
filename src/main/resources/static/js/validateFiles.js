
$(document).ready(function () {
    var table = $('#fileTable').DataTable(        {
            serverSide: true,
            ajax: {
                url: basicUrl + '/files',
                type: 'POST'
            },
            "columns": [
                {
                    "data": "id",
                    "visible": false
                },

                {
                    title: "name",
                    "data": "name"
                },


                {
                    title: "edit",
                    "targets": -1,
                    "data": null,
                    "defaultContent": '<button type="button" name = "btnEdit" class="btn btn-primary btn-xs" data-title="Edit" ' +
                        'data-toggle="modal" data-target="#editOrCreate"> ' +
                        '<span class="glyphicon glyphicon-pencil"></span> ' +
                        '</button>'
                },
                {
                    title: "delete",
                    "targets": -1,
                    "data": null,
                    "defaultContent": '<button type="button" name = "btnDelete" class="btn btn-danger btn-xs btnDelete" data-title="Delete"> ' +
                        '<span class="glyphicon glyphicon-trash"></span></button>'
                }
            ]
        }
    );
});