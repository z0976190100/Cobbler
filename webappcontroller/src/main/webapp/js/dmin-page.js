var localState;
var globalState;

/*
$(function () {
    $("#multiplayer-check").on("click", function () {
        localState = $("#multiplayer-check").is(":checked");
        console.log("local state is " + localState);
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestType: "registration", mp: localState}

        });

     });
});


    $(function () {
        $("html").on("mousemove", function () {
console.log("getting....");
            $.ajax({
                type: "POST",
                url: "/testmaven",
                dataType: "json",
                data: {requestType: "registration", mp: "get"},
                success: function (data) {
                     globalState = data.mp;
                    console.log("now global state is " + globalState );
                    $("#multiplayer-check").prop("checked", globalState);
                }

            });

        });

    });


*/


var HandlebarsContext = {
    userLine: []

};

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
                };
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
};


var responseParser = function (json) {


};

var gogoHandlebars = function () {

    var templToCompile = document.getElementById("users-table-template").innerHTML;

    var templCompiled = Handlebars.compile(templToCompile);

    var insertingData = templCompiled(HandlebarsContext);


    document.getElementById("user-table-div").innerHTML += insertingData;
};