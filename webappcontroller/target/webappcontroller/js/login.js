
$(function() {
    $("#card").flip({
        trigger: 'click'
    });
});


/*
$("#flip-btn").click(function() {

    $(".signin_form").css('opacity', '0');
    $(".signup_form").css('opacity', '100');


    $("#card").flip(true);

    return false;
});

$("#unflip-btn").click(function(){

    $(".signin_form").css('opacity', '100');
    $(".signup_form").css('opacity', '0');

    $("#card").flip(false);

    return false;

});
*/



var main = {
    registration: function () {
        var input = document.getElementById("myinput").value;
        /*var email = document.getElementById("mailReg").value;
        var pass = document.getElementById("passReg").value;*/
        $.ajax({
            type: "POST",
            url: "/testmaven",
            dataType: "json",
            data: {requestType: "registration", login: input}, // email: email, password: pass},
            success: function (data) {
                $("#mybutt").attr("value", data.login);

                //document.location.href = 'index.html';
            }
        });
    },

    log_in: function () {
        var log = document.getElementById("login").value;
        var pass = document.getElementById("password").value;
        $.ajax({
            type: "POST",
            url: "/test-maven",
            dataType: "json",
            data: {requestType: "login", login: log, password: pass},
            success: function (data) {
                if(data.name == "error")
                    document.location.href = 'errorPage.html';
                else
                    document.location.href = 'User_cabinet.html';
                    window.onload = function() {
                        document.getElementById("name").innerHTML = data.name;
                        document.getElementById("index").innerHTML = data.indexNumber;
                }

            }
        });
    }


};


