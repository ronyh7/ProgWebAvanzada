$( document ).ready(function() {


        $.get("/sub_familias/", function(data, status){
                var headers = [];
                var values = [];
            data.forEach(function (d) {
                headers.push(d[1]);
                values.push(parseFloat(d[0]).toPrecision(4));

            });
            var max = Math.ceil(Math.max(...values));
            console.log(max);
            $("#demo").jChart({
                name: "Promedios de duracion de alquiler por subfamilia",
                headers: headers,
                values: values,
                footers: [max/4,max/2,max*(3/4),max],
                colors: ["#F4C2C2","#FF6961","#FF1C00","#FF0800","#A40000"]
            });
        });

    $.get("/familias/", function(data, status){
        var headers = [];
        var values = [];
        data.forEach(function (d) {
            headers.push(d[1]);
            values.push(parseFloat(d[0]).toPrecision(4));

        });
        var max = Math.ceil(Math.max(...values));
        console.log(max);
        $("#demo2").jChart({
            name: "Promedios de duracion de alquiler por familia",
            headers: headers,
            values: values,
            footers: [max/4,max/2,max*(3/4),max],
            colors: ["#F4C2C2","#FF6961","#FF1C00","#FF0800","#A40000"]
        });



    });




});
