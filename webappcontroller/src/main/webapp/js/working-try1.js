$(function () {
    $(".glyphicon").on("mouseover", function () {
        $(".glyphicon").css("color", "white");
        $(".glyphicon").css("cursor", "hand");
    });

    $(".glyphicon").mouseleave(function () {
        $(".glyphicon").css("color", "#6600cc");
    });

});


var techRouteHandlebarsContext = {
    modelArt: "",
    listLines: []

}

var operationRegister = [];

var tableCellId = 1;

var dataRequest = {
    getTechRouteByModel: function (event) {
        event.preventDefault();
        event.stopPropagation();
        var article = $("#all-tech-route-select").val();
        // document.cookie = "username=admin";
        loader.on();
        console.log(article);
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestType: "getTechRouteByModel", article: article},
            success: function (data) {
                loader.off();
                if (data !== null) {

                    console.log(data.operation_list);
                    responseHandler.responseParser(data.operation_list, article);
                }
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

    techRouteComitment: function () {
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
    },

    getAllTechRoutsArticles: function () {
        loader.on()
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestType: "getAllTechRoutsArticles"},
            success: function (data) {
                loader.off();
                var autocompleteArr = [];
                var count = 0;
                for (var key in data) {
                    if (key !== "requestProcessingTime") {
                        modelArtMap = data;
                        autocompleteArr[count]=(data[key]);
                        count++;
                    }
                    console.log(autocompleteArr);

                   $(function () {

                    $("#all-tech-route-select").autocomplete({
                            source: autocompleteArr
                        });
                   })

                    }
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

        console.log(templToCompile);

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
var loader = {
    on: function () {
        $(".loader").css("display", "block");
        $("html body").css("background", "#6600cc");
    },
    off: function () {
        $(".loader").css("display", "none");
        $("html body").css("background", "rgba(0,0,0,0)");
    }
};