var basicUrl = 'http://localhost:8080';
$(".btnDelete").click(function() {
    console.log("Delete " +this.name);
    $.ajax({
        'type': 'DELETE',
        'url': basicUrl + "/delete?id="+this.name,
        'contentType': 'application/json',
        'success': function(data, status){redirect(basicUrl);},
        'error': function (xhr, status) {
            alert(xhr.responseJSON.message);
        }
     });
});


function edit(id) {
    console.log("Edit " + id);
    var currentCar = carsValue.filter(function(car){
    return car.id === parseInt(id);});
    currentCar = currentCar[0];
    $('#idNumber').val(id);
    $('#carNumber').val(currentCar.number);
    $('#carType').val(currentCar.carType).change();
    $('#carProducer').val(currentCar.producer).change();
    $('#carName').append($("<option></option>").attr("value",currentCar.model)
                                    .text(currentCar.model));
    $('#carName').val(currentCar.model).change();
    $('#carDescription').val(currentCar.description);
}

$('#editOrCreate').on('shown.bs.modal', function (e) {
    resetValidation();
})

jQuery("#carProducer").change(function(){
    var producer = jQuery('#carProducer').val();
    $('#carName').children('option:not(:first)').remove();
    if(producer==="0") {
        return;
    }
    $.ajax({
        'type': 'GET',
        'url': basicUrl + "/model?producer="+producer,
        'contentType': 'application/json',
        'success': function(data, status){
            $.each(data, function(key, value) {
            var options = $('#carName option')
                .filter(function(i, e) { return $(e).text() === value});
                 if(options.length===0){
                    $('#carName').append($("<option></option>").attr("value",value).text(value));
                }
            });
        },
        'error': function (xhr, status) {
            alert(xhr.responseJSON.message);
        }
 });
});

function saveOrEditCar() {
    $.ajax({
        'type': 'POST',
        'url': basicUrl + "/save",
        'contentType': 'application/json',
        'data': JSON.stringify({
            id: $('#idNumber').val(),
            number: $('#carNumber').val(),
            carType: $('#carType').val(),
            model:$('#carName').val(),
            producer:$('#carProducer').val(),
            description:$('#carDescription').val()
            }),
        'dataType': 'json',
        'success': function(data, status){
            redirect(basicUrl);
        },
        'error': function (xhr, status) {
            alert(xhr.responseJSON.message);
        }
     });
}

function redirect(url){
    $(document).ready( function() {$( location ).attr("href", url);});
}