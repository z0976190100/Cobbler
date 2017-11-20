




var techRouteHandlebarsContext = {
    modelArt: "",
    listLines: []

}

var operationRegister = [];

var tableCellId = 1;

var dataRequest = {
    getTechRouteByModel: function () {
        var article = $("#m1").val();
       // document.cookie = "username=admin";
        $(document).ajaxStart(function(){
            $("#loader").css("display", "block");
            $("html body").css("background", "#6600cc")
        });
        console.log(article);
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestType: "getTechRouteByModel", article: article},
            cookies: {foo: "modelSearch"},
            success: function (data) {
                $(document).ajaxComplete(function(){
                    $("#loader").css("display", "none");
                    $("html body").css("background", "rgba(0,0,0,0)")
                });
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
        $(ev).prop("disabled", true);
        operationRegister.push(ev);
    },

    techRouteCommitment: function(){
        console.log(operationRegister);
        //dataRequest.techRouteFinalize(operationRegister);
    },

    techRouteFinalize: function (opReg) {
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestType: "techRouteCommit", operationRegister: opReg},
            success: function (data) {
                // activating input field for next model input

            }

        });
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
        for (var i = 0; i < respPieces.length; i++) {
            var temp = tableCellId + article + opcounter ;
            techRouteHandlebarsContext.modelArt = article;
            techRouteHandlebarsContext.listLines.push({
                inputLabelBody:
                "<input onclick =\"dataRequest.operationCheked(event)\" id=\"" + temp + "\" type=\"checkbox\">" +
                "<label id=\"" + temp + "\" for = \"" + temp + "\" onclick =\"dataRequest.operationCheked(event)\">"    //
                + respPieces[i] + "</label><br>"
            });
            opcounter++;
            console.log(techRouteHandlebarsContext.listLines)
        }
        gogoHandlebars();
        techRouteHandlebarsContext.listLines = [];
    }

}


var gogoHandlebars = function () {

tableCellId ++;

    var templToCompile = document.getElementById("tech-route-template").innerHTML;

    console.log(templToCompile);

    var templCompiled = Handlebars.compile(templToCompile);

    var insertingData = templCompiled(techRouteHandlebarsContext);

    document.getElementById("tech-route").innerHTML += insertingData;
}