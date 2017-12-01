var modelArtMap;
var techRouteHandlebarsContext = {
    modelArt: "",
    listLines: []
};

var operationRegister = [];
var tableCellId = 1;

var dataRequest = {
    getTechRouteByModel: function (event) {
        event.preventDefault();
        event.stopPropagation();
        var article = $("#all-tech-route-select").val();
        for (var key in modelArtMap) {
            console.log(modelArtMap[key]);
            if (modelArtMap[key] === article) {
                loader.on();
                console.log(article);
                $.ajax({
                    type: "POST",
                    url: "/testmaven",
                    dataType: "json",
                    data: {requestCase: "getTechRouteByModel", article: article},
                    success: function (data) {
                        loader.off();
                        if (data !== null) {

                            console.log(data.operation_list);
                            responseHandler.responseParser(data.operation_list, article);
                        }
                    }
                });
                return true;
            }
        }
        alert("Несуществующий артикул.");
        return false;
    },

    operationCheked: function (event) {
        console.log(event.target.id);
        var ev = "#" + event.target.id;
        $(ev).prop("checked", true);
        $(ev).prop("disabled", true);
        operationRegister.push(ev);
    },

    techRouteComitment: function () {
        console.log(operationRegister);
        //dataRequest.techRouteFinalize(operationRegister);
    },

    techRouteFinalize: function (opReg) {
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestCase: "techRouteCommit", operationRegister: opReg},
            success: function (data) {
                // activating input field for next model input

            }
        });
    },

    getAllTechRoutsArticles: function () {
        loader.on()
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestCase: "getAllTechRoutsArticles"},
            success: function (data) {
                loader.off();
                var autocompleteArr = [];
                var count = 0;
                for (var key in data) {
                    if (key !== "requestProcessingTime") {
                        modelArtMap = data;
                        autocompleteArr[count] = (data[key]);
                        count++;
                    }
                    console.log(autocompleteArr);

                    $(function () {
                        $("#all-tech-route-select").autocomplete({
                            source: autocompleteArr
                        });
                    })
                }
            },
            error: function () {
                alert("Press F5 button or Refresh page");
            }
        });
    }
};

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
            var temp = tableCellId + article + opcounter;
            techRouteHandlebarsContext.modelArt = article;
            techRouteHandlebarsContext.listLines.push({
                inputLabelBody:
                "<input onclick =\"dataRequest.operationCheked(event)\" id=\"" + temp + "\" type=\"checkbox\">" +
                "<label style='color: #3c3c3c;' id=\"" + temp + "\" for = \"" + temp + "\" onclick =\"dataRequest.operationCheked(event)\">"    //
                + respPieces[i] + "</label><br>"
            });
            opcounter++;
            console.log(techRouteHandlebarsContext.listLines)
        }
        gogoHandlebars("tech-route");
        techRouteHandlebarsContext.listLines = [];
    }
};

var gogoHandlebars = function (target) {
    var handlebarsAct = function (target, templateId) {
        var templToCompile = document.getElementById(templateId).innerHTML;
        var templCompiled = Handlebars.compile(templToCompile);
        var insertingData = templCompiled(techRouteHandlebarsContext);

        document.getElementById(target).innerHTML += insertingData;
        console.log("Handelbars done!");
    };

    switch (target) {
        case "tech-route":
            tableCellId++;
            templateId = "tech-route-template";
            handlebarsAct(target, templateId);
            break;
        case "all-tech-route-select":
            templateId = "all-tech-route-select-template";
            handlebarsAct(target, templateId);
            break;
        default:
            console.log("no hendelbars handler yep...");
    }
};
