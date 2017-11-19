var gogo = function () {


    var templToCompile = document.getElementById("templ").innerHTML;

    console.log(templToCompile);

    var templCompiled = Handlebars.compile(templToCompile);

    var insertingData = templCompiled({
        title: "<button>dis body</button>",
        bodies: [
            {body: "body"},
            {body: "nobody"},
            {body: "anybody"}
         ]
    });

    document.getElementById("here-it-appears").innerHTML += insertingData;
}