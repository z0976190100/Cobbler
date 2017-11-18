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
            }

        });

    },
    operationCheked: function (event) {

    }
}

var responseHandler = {

}

var techRouteHandlebarsContext = {
    trcount: 1,
    opcount: 1,
    routeFormId: "tech-route"+ this.trcount,
    inputBody: "<input onclick =\"dataRequest.operationCheked(event)\" name=\"operation"+ techRouteHandlebarsContext.opcount+"\" type=\"checkbox\">",
    labelBody: ""

}
