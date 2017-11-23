//database initialisation
$(function () {
    $.ajax({
        type: "POST",
        url: "/testmaven",
        dataType: "json",
        data: {requestType: "dbInit"},
        success: function () {
            $("#card").flip({
                trigger: 'manual'
            });
            $("#flip-btn").prop("disabled", false);
        },
        error: function () {
            alert("Press F5 button or Refresh page");
        }
    });
});

var main = {

    errorMesage: "",

    validation: function (param1, param2, cause) {
        if (param1 !== param2) {
            switch (cause) {
                case "secrets_are_equal":
                    main.errorMesage = "Ах! Повтор пароля не совпадает. Давай еще разок. И повнимательней!";
                    return false;
            }
        }
        return true;
    },

    fieldRestriction: function (contentValue, fieldId) {
        switch (contentValue){
            case "":
                $(fieldId).css("border-color", "red");
                alert("Поле не заполнено!");
                return true;
            default: return false;
        }
return false;
    },

    registrationLocal: function () {
        var name = $("#name_input").val();
        if(main.fieldRestriction("", ".name_input")) return;
        var surname = $("#surname_input").val();
        var employment = $("#employment_input").val();
        var role = $("#role_input").val();
        var phonenumber = $("#phonenumber_input").val();
        var secret1 = $("#secret1_input").val();
        var secret2 = $("#secret2_input").val();
        if (!main.validation(secret1, secret2, "secrets_are_equal")) {
            $("#secret1_input").val("");
            $("#secret2_input").val("");
            alert(main.errorMesage);
            return;
        }
        main.registration(name, surname, employment, role, phonenumber, secret1);
    },

    registration: function (nam, surnam, employmen, rol, phonenumbe, secre) {
        console.log("local validation is passed. sending request...");
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {
                requestType: "registration",
                name: nam,
                surname: surnam,
                employment: employmen,
                role: rol,
                phonenumber: phonenumbe,
                secret: secre
            },
            success: function (data) {
                if (data.registration == "win") {
                    console.log("registration win")
                    main.unflip();
                    document.location.href = 'working-flow.html';
                    return;
                }
                alert("Такие уже есть, еще разик");
                return;
            }
        })
    },


    log_in: function () {
        document.location.href = 'working-try.html';
        /*var log = document.getElementById("login").value;
        var pass = document.getElementById("password").value;
        var $phonenumber = $("#phonenumber_input").value;
        var $secret = $("#secret_input").value;

        $.ajax({
            type: "POST",
            url: "/test-maven",
            dataType: "json",
            data: {requestType: "login", login: log, password: pass},//!!!!!!!!!!!!!
            success: function (data) {
                if (data.name == "error")
                    document.location.href = 'errorPage.html';
                else
                    document.location.href = 'User_cabinet.html';
                window.onload = function () {
                    document.getElementById("name").innerHTML = data.name;
                    document.getElementById("index").innerHTML = data.indexNumber;
                }

            }
        });*/
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

    }


};
// to remove red border fom wrong input field
    $("#name_input").focus(function () {
        $("#name_input").css("border-color", "#6600cc");
});
//  flip action
$(function () {
    $("#flip-btn").click(function () {

        $(".signin_form").css('opacity', '0');
        $(".signup_form").css('opacity', '100');
        $("#card").flip(true);

        return false;
    });

    $("#unflip-btn").click(main.unflip());
});

