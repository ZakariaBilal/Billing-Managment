// fonction gestion input datalist

function createAlert(msg, container) {

    var alert = '<div class="alert alert-danger alert-dismissible fade show" id="danger-alert" role="alert">' +
        '<strong>' + msg + '</strong>' +
        '<button type="button" class="close" data-dismiss="alert" aria-label="Close">' +
        ' <span aria-hidden="true">&times;</span>' +
        '</button>' +
        '</div>'


    $("<div/>", {
        "id": "alert-div",
        html: alert
    }).prependTo(container);

    $("#danger-alert").fadeTo(2000, 500).slideUp(500, function () {
        $("#danger-alert").slideUp(500);
        $("#alert-div").remove();
    });
}


$(document).ready(function () {
    $("#clientInput").change(function () {
        if ($("#clientInput").val() == "") {
            $("#clientNameText").text("");
        } else {
            var val = $("#clientInput").val();
            var obj = $("#clients").find("option[value='" + val + "']");
            let option = $("#client" + $("#clientInput").val());
            $("#clientNameText").text(option.text());
            if (obj != null && obj.length > 0) {
                console.log("client valid");
                clientValid = true;
            } else {
                clientValid = false;
                createAlert("Le navire n'est pas valide", "#formContainer");
                console.log("client invalid");
            }
        }
    });
});