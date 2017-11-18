$(function () {
    $("#card").flip({
        trigger: 'manual'
    });
});


$(document).ready(function () {
    $("#flip-btn").click(function () {

        $(".signin_form").css('opacity', '0');
        $(".signup_form").css('opacity', '100');


        $("#card").flip(true);

        return false;
    });


    $("#unflip-btn").click(function () {

        $(".signin_form").css('opacity', '100');
        $(".signup_form").css('opacity', '0');

        $("#card").flip(false);

        return false;

    });
});


var main = {
    registration: function () {
        var $name = $("#name_input").val();
        var $surname = $("#surname_input").val();
        var $phonenumber = $("#phonenumber_input").val();
        var $secret = $("#secret_input").val();
        console.log($name);
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {
                requestType: "registration",
                name: $name,
                surname: $surname,
                phonenumber: $phonenumber,
                secret: $secret
            },
            success: $(function () {
                // display "now enter with your new credentials" on login page
                // $("#mybutt").attr("value", data.login);
                $(".signin_form").css('opacity', '100');
                $(".signup_form").css('opacity', '0');

                $("#card").flip(false);
                console.log("success");


                document.location.href = 'working-try.html';
                return false;
            })
        });
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
    }


};


