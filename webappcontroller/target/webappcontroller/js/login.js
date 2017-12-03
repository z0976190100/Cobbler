//database initialisation
var currentUser;
var currentRole;
var currentUserId;
var localState;
var globalState;
var contentToSync = [
    {target: "", localState: "", globalState: ""}
];

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

var main = {

    errorMesage: "",

    validation: function (param1, param2, cause) {
        if (param1 !== param2) {
            switch (cause) {
                case "secrets_are_equal":
                    main.errorMesage = "Ах! Повтор пароля не совпадает. Давай еще разок. И повнимательней!";
                    return false;
                /*
                                case "is_field_empty":
                                    $(fieldId).css("border-color", "red");
                                    alert("Поле не заполнено!");
                                    return false;
                */
            }
        }
        return true;
    },

    fieldRestriction: function (contentValue, fieldId) {
        var fieldContent = $(fieldId).val();
        if (contentValue == fieldContent) {
            switch (contentValue) {
                case "":
                    $(fieldId).css("border-color", "red");
                    alert("Поле не заполнено!");
                    return true;
                default:
                    return false;
            }
        }
        return false;
    },

    registrationLocal: function () {
        var reg = {
            name: "#name_input",
            surname: "#surname_input",
            employment: "#employment_input",
            role: "#role_input",
            phonenumber: "#phonenumber_input",
            secret1: "#secret1_input",
            secret2: "#secret2_input"
        };

        var mist = false;

        for (var key in reg) {
            if (!main.fieldRestriction("", reg[key])) {
                console.log(reg[key]);
                reg[key] = $(reg[key]).val();
                console.log(reg[key])
            } else {
                mist = true;
            }
        }
        if (mist) return false;

        if (!main.validation(reg.secret1, reg.secret2, "secrets_are_equal")) {
            $("#secret1_input").val("");
            $("#secret2_input").val("");
            alert(main.errorMesage);
            return false;
        }
        main.registration(reg.name, reg.surname, reg.employment, reg.role, reg.phonenumber, reg.secret1);
    },

    registration: function (nam, surnam, employmen, rol, phonenumbe, secre) {
        console.log("local validation is passed. sending request...");
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {
                requestCase: "registration",
                name: nam,
                surname: surnam,
                employment: employmen,
                role: rol,
                phonenumber: phonenumbe,
                secret: secre
            },
            success: function (data) {
                if (data.registration == "win") {
                    console.log("registration win");
                    main.unflip();
                    alert("Учетная запись создана. Войдите с новыми учетными данными.");
                    return;
                }
                alert("Такие уже есть, еще разик");
                return;
            }
        })
    },

    log_in: function (event) {
        var ev = event.target.id;
        var secret = $("#secret-input-auth").val();
        var phonenumber = $("#login-input-auth").val();
        console.log("log" + phonenumber + " pass " + secret);
        loader.on();
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestCase: "auth", case: "login", phonenumber: phonenumber, secret: secret},
            success: function (data) {
                if (data.auth == "fail") {
                    switch (ev) {
                        case "log-in-btn":
                            loader.off();
                            alert('Неверные данные.');
                            return false;
                        case "flip-btn1":
                            loader.off();
                            alert('Войдите как Администратор.');
                            return false;
                    }
                } else {
                    currentUserId = data.id;
                    currentUser = data.firstName;
                    currentRole = data.role;
                    document.cookie = "user=" + currentUser;
                    document.cookie = "role=" + currentRole;
                    document.cookie = "id=" + currentUserId;
                    document.cookie = "pn=" + phonenumber;
                    document.cookie = "authStatus=" + "true";
                    main.helloString();
                    switch (ev) {
                        case "log-in-btn":
                            loader.off();
                            main.changeScene("#second", "#first");
                            main.roleActions(currentRole);
                            return true;
                        case "flip-btn1":
                            if (currentRole == "admin") {
                                loader.off();
                                main.flip();
                                return;
                            }
                            loader.off();
                            alert('Войдите как Администратор.');
                            return true;
                    }
                    return true;
                }
            }
        });
    },

    helloString : function () {
        document.getElementById("hello").innerHTML = ("Добрый день, " + main.getCookie("user"));
    },

    log_out: function () {
        loader.on();
      var phonenumber = main.getCookie("pn");
        console.log(phonenumber);
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestCase: "auth", case: "logout", phonenumber: phonenumber },
            success: function (data) {
                console.log(data.auth);
                document.cookie = "authStatus=" + "false";
                loader.off();
                main.changeScene("#first", "#second");
            }

        })
    },

    roleActions: function (data) {
        switch (data) {
            case "admin":
                return;
            case "superuser":
                console.log("role user");
                $("#dmin-button").prop("disabled", "true");
                return;
            case "user":
                console.log("role user");
                $("#dmin-button").prop("disabled", "true");
                return;
        }


    },

    flip: function () {
        $(".signin_form").css('opacity', '0');
        $(".signup_form").css('opacity', '100');
        $("#card").flip(true);
        return false;
    },

    unflip: function () {
        $(".signin_form").css('opacity', '100');
        $(".signup_form").css('opacity', '0');
        $("#card").flip(false);
        return false;
    },

    changeScene: function (sceneIdShow, sceneIdHide) {

        $(sceneIdHide).css("display", "none");
        $(sceneIdShow).css("display", "block");

    },

    getCookie: function (cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    }
};


// onload initialisations
$(function () {

    $(".glyphicon").on("mouseover", function () {
        $(".glyphicon").css("color", "white");
        $(".glyphicon").css("cursor", "hand");
    });

    $(".glyphicon").mouseleave(function () {
        $(".glyphicon").css("color", "#6600cc");
    });

    // hamburger menu setting
    $(".toggle-menu").on("click", function () {
        var tagState = $("#toggle-menu").is(":checked");
        console.log(tagState);
        if (tagState) {
            $("#inhamburger").css("visibility", "visible");
        }
        else {
            $("#inhamburger").css("visibility", "hidden");
        }
    });

// jquery flip setting
    $("#card").flip({
        trigger: 'manual'
    });
    $("#flip-btn").prop("disabled", false);

    loader.on();
    // check coockies if alredy logged in
    if (main.getCookie("authStatus") == "true") {
        main.changeScene("#second", "#first");
        loader.off();
        return;
    }

    $.ajax({
        type: "POST",
        url: "/testmaven",
        dataType: "json",
        data: {requestCase: "dbInit"},
        success: function () {
            loader.off();
            main.changeScene("#first", "#second");
        },
        error: function () {
            alert("Press F5 button or Refresh page");
        }
    });
});


/*

$(function () {
    $(".multiuser-syncronized-checkboxes").on("click", function (event) {
        localState = $(event.target.id).is(":checked");
        console.log("local state is " + localState);
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestCase: "state", localState: localState, initiator: currentUserId } //String opTagId, boolean state, long init

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
            data: {requestCase: "state", purpose: "get"},
            success: function (data) {
                if(data.syncRequired){
                    contentToSync = data;
                    main.contentSyncronization(data);}
                /!*console.log("now global state is " + globalState);
                $("#multiplayer-check").prop("checked", globalState);*!/
            }

        });
    });

});

var HandlebarsContext = {
    userLine: []
};

var dminActions = {
    getAllUsers: function () {
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestCase: "getAllUsers"},
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
            data: {requestCase: "destroyUser", userIdTD: andNowUserIdToDestroyIiiiis},
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
};*/
