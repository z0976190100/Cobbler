
var HandlebarsContext = {
   userLine: [
       {userId: ""},
       {userSurname: ""}
    ]
}

var dminActions = {
    getAllUsers: function () {
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestType: "getAllUsers"},
            success: function (data) {
                console.log(data)
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

    document.getElementById("tech-route").innerHTML += insertingData;
}