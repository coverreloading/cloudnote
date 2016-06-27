$(function () {
    $().ready(function () {
        $(".pwdMessage").hide();
    })
});
function pwdRequired() {
    var password2 = document.getElementById("form-password");
    var password = document.getElementById("form-repeat-password");
    // var password2 = $("form-password");
    // var password =$("form-repeat-password");
    if (password2.value != password.value || password == null || password2 == null) {
        $(".pwdMessage").show();
        $("#submitbutton").attr("disabled", "true");
        // document.getElementById("password_check1").innerHTML = "密码      (   ´_ゝ｀   )您可能是输错密码的受害者";
        // document.getElementById("password_check2").innerHTML = "确认密码  (   ´_ゝ｀   )";
        return false;
    }
    else if (password2.value == password.value && password != null) {
        $(".pwdMessage").hide();
        $("#submitbutton").removeAttr("disabled");
    }
}
function updateCheck() {
    var userName = ("#user-name");
    var age = ("#age");
    var sex = ("#sex");
    var phone = ("#phone");
    if (userName == null || age == null ||  phone == null) {
        $("#submitbutton").attr("disabled", "true");
    }else {
        $("#submitbutton").removeAttr("disabled");
    }
}
