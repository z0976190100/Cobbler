var HandlebarsContext = {
    userLine: []

}

var dminActions = {
    getAllUsers: function () {
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestType: "getAllUsers"},
            success: function (data) {
                HandlebarsContext = {
                    userLine: []
                }
                for (var key in data) {
                    if (key !== "requestProcessingTime")
                        HandlebarsContext.userLine.push({userId: key, userSurname: data[key]});
                    console.log(HandlebarsContext.userLine);
                }
                gogoHandlebars();
            }
        });
    },
    destroyUser: function (event) {
        var andNowUserIdToDestroyIiiiis = event.target.name;
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestType: "destroyUser", userIdTD: andNowUserIdToDestroyIiiiis},
            complete: function () {
                document.getElementById("user-table-div").innerHTML = "";
                dminActions.getAllUsers();
            }
        });
    }
}


var responseParser = function (json) {


}

var gogoHandlebars = function () {

    var templToCompile = document.getElementById("users-table-template").innerHTML;

    var templCompiled = Handlebars.compile(templToCompile);

    var insertingData = templCompiled(HandlebarsContext);


    document.getElementById("user-table-div").innerHTML += insertingData;
}