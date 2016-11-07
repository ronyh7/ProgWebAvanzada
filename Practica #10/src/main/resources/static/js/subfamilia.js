/**
 * Created by rony on 06/11/16.
 */
$( document ).ready(function() {
    $.get("/subfamilias?id="+ $('#familiaEquipo').val(), function(data, status){
        $('#subFamilia').empty();
        data.forEach(function (sub) {

            var selected = parseInt(sub.id) === parseInt($('#sub').val());
            console.log($('#sub').val());
            console.log(sub.id);
            $('#subFamilia').append($('<option>', {
                value: sub.id,
                text: sub.nombre,
                selected: selected
            }));
        })
    });

    $('#familia').on('change', function() {
        $.get("/subfamilias?id="+ $('#familiaEquipo').val(), function(data, status){
            $('#subFamilia').empty();
            data.forEach(function (sub) {
                var html = '<option value="'+data.id+'" >'+data.nombre+'</option>';
                $('#subFamilia').append($('<option>', {
                    value: sub.id,
                    text: sub.nombre
                }));
            })
        });
    });


});