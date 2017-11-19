var techRouteHandlebarsContext = {
    routeFormId: "tech-route" + 857,
    listLines: []

}

var

var dataRequest = {
    getTechRouteByModel: function () {
        var article = $("#m1").val();
        console.log(article);
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestType: "getTechRouteByModel", article: article},
            success: function (data) {
                // inserting recieved data into DOM
                console.log(data.operation_list);
                responseHandler.responseParser(data.operation_list, article)
            }

        });

    },
    operationCheked: function (event) {
console.log(event.target.id);
var ev = "#" + event.target.id;
$(ev).prop("checked", true);
$(ev).prop("disabled",true);
    }
}

/*
function TechRouteObj() {
    this.trcount = 1;
    this.opcount = 1;
    this.techRouteHandlebarsContext = {
        routeFormId: "tech-route"+ this.trcount,
        inputBody: "<input onclick =\"dataRequest.operationCheked(event)\" name=\"operation"+ this.opcount+"\" type=\"checkbox\">",
        labelBody: []

    }
}
*/

var responseHandler = {

    responseParser: function (response, article) {

        var respPieces = response.split(",");
        var opcounter = 1;
        for( var i = 0; i< respPieces.length ; i++) {
            var temp = article + opcounter;
            techRouteHandlebarsContext.listLines.push({
                inputLabelBody:
                    "<input onclick =\"dataRequest.operationCheked(event)\" id=\"" + temp + "\" type=\"checkbox\">" +
                    "<label id=\"" + temp +"\" for = \"" + temp + "\" onclick =\"dataRequest.operationCheked(event)\">"    //
                    + respPieces[i] + "</label><br>"});
            opcounter++;
            console.log(techRouteHandlebarsContext.listLines)
        }
        gogo();
        techRouteHandlebarsContext.listLines = [];
    }

}




var gogo = function () {


    var templToCompile = document.getElementById("tech-route-template").innerHTML;

    console.log(templToCompile);

    var templCompiled = Handlebars.compile(templToCompile);

    var insertingData = templCompiled(techRouteHandlebarsContext);

    document.getElementById("tech-route").innerHTML += insertingData;
}