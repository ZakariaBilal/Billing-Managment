var counter = 1;

var clientValid = false;
var navireValid = false;

var prestationValid = false;

function addInput(divName) {

    var newdiv = document.createElement("div");

    var div = $("<div/>", {
        'class': 'row',
        'id': counter,
    }).append($("<div/>", {
        'class': 'col-3 mb-4'
    }).append($("<div/>", {
        'class': 'input-group'
    }).append($("<input/>", {
        'list': 'prestations',
        'name': 'ligneBulletins[' + counter + '].prestation',
        'class': 'form-control prestation',
        'required': "1",
        'placeholder': 'Code Prestation',
        'numero': counter,
        'title': 'Code Prestation'
    })).append(
        $("<div/>", {
            'class': 'input-group-append'
        }).append($("<div/>", {
            'class': 'input-group-text'
        }).append($("<span/>", {
            'id': 'prestation' + counter + 'Text'
        })))
    ))).append($("<div/>", {
        'class': 'col-2'
    }).append($("<input/>", {
        'type': 'number',
        'name': 'ligneBulletins[' + counter + '].quantite',
        'class': 'form-control mb-4',
        'placeholder': 'quantite',
        'title': 'Quantite',
        'min': 0
    }))).append($("<div/>", {
        'class': 'col-3'
    }).append($("<input/>", {
        'type': 'datetime-local',
        'class': 'form-control',
        'name': 'ligneBulletins[' + counter + '].dateDebut',
        'required': '1',
        'title': 'date Debut'
    }))).append($("<div/>", {
        'class': 'col-3'
    }).append($("<input/>", {
        'type': 'datetime-local',
        'class': 'form-control',
        'name': 'ligneBulletins[' + counter + '].dateFin',
        'required': '1',
        'title': 'date Fin'
    }))).append($("<div/>", {
        'class': 'col-1'
    }).append($('<input/>', {
        'class': 'btn btn-danger',
        'onClick': 'deleteInput(' + counter + ');',
        'type': 'button',
        'value': 'delete'
    })));

    $("#" + divName).append(div);

    counter++;

    $(".prestation").unbind();
    $(".prestation").each(function (i) {
        $(this).change(function () {
            var numero = $(this).attr('numero');
            if ($(this).val() == "") {
                $("#prestation" + numero + "Text").text("");
            } else {
                var val = $(this).val();

                var obj = $("#prestations").find("option[value='" + val + "']");
                let option = $("#prestation" + $(this).val());
                $("#prestation" + numero + "Text").text(option.text());

                if (obj != null && obj.length > 0) {
                    console.log("prestation valid");
                    console.log(numero);
                    navireValid = true;

                } else {
                    navireValid = false;
                    console.log("prestation invalid");
                }
            }
        });
    });

}

function init() {
    counter = $(".prestation").length;
    if ($("#clientInput").val() == "") {
        $("#clientNameText").text("");

    } else {

        var val = $("#clientInput").val();

        var obj = $("#clients").find("option[value='" + val + "']");
        let option = $("#client" + $("#clientInput").val());
        $("#clientNameText").text(option.text());

        if (obj != null && obj.length > 0) {
            console.log("client valid");
            clientValid = true
            $.getJSON("/api/navires/client/" + $("#clientInput").val(), function (data) {
                var items = [];
                console.log("json");
                $.each(data, function (key, navire) {
                    items.push("<option id='navire" + navire.codeNavire + "' value = '" + navire.codeNavire + "'>" + navire.nomNavire + "</option>");
                });
                if (items.length > 0) {
                    $("#navireInput").attr("disabled", false);
                }

                $("<datalist/>", {
                    "id": "navires",
                    html: items.join("")
                }).appendTo("#navires-datalist");
                if ($("#navireInput").val() == "") {
                    $("#navireNameText").text("");
                } else {
                    var val = $("#navireInput").val();

                    var obj = $("#navires").find("option[value='" + val + "']");
                    let option = $("#navire" + $("#navireInput").val());
                    $("#navireNameText").text(option.text());
                    if (obj != null && obj.length > 0) {
                        console.log("navire valid");
                        navireValid = true;
                    } else {
                        navireValid = false;
                        createAlert("Le navire n'est pas valide", "#bulletinAddContainer");
                        console.log("navire invalid");
                    }
                }
            });
        } else {
            console.log("client invalid");
            createAlert("Le client n'est pas valide", "#bulletinAddContainer");
            clientValid = false;
        }

    }

    $(".prestation").each(function (i) {
        var numero = $(this).attr('numero');
        if ($(this).val() == "") {
            $("#prestation" + numero + "Text").text("");
        } else {
            var val = $(this).val();

            var obj = $("#prestations").find("option[value='" + val + "']");
            let option = $("#prestation" + $(this).val());
            $("#prestation" + numero + "Text").text(option.text());

            if (obj != null && obj.length > 0) {
                console.log("prestation valid");
                console.log(numero);
                navireValid = true;

            } else {
                navireValid = false;
                createAlert("La prestation n'est pas valide", "#bulletinAddContainer");
                console.log("prestation invalid");
            }
        }
    });
}

function deleteInput(id) {
    document.getElementById(id).remove();
}


function clearNavireInput() {
    $("#navireInput").attr("disabled", true);
    $("#navires-datalist").empty();
    $("#navireNameText").text("");
    $("#navireInput").val("");
}

$(document).ready(function () {
    init();

    $("#bulletinForm").submit(function (e) {
        navireInput = $("#navireInput").val();

        if (navireInput != null && navireInput.length > 0 && clientValid && navireValid) {

            return true;
        } else {
            console.log("add a navire");
            createAlert("Le navire est invalide", "#bulletinAddContainer");
            return false;
        }
    });
    $("#clientInput").change(function () {
        clearNavireInput();
        if ($("#clientInput").val() == "") {
            $("#clientNameText").text("");

        } else {

            var val = $("#clientInput").val();

            var obj = $("#clients").find("option[value='" + val + "']");
            let option = $("#client" + $("#clientInput").val());
            $("#clientNameText").text(option.text());

            if (obj != null && obj.length > 0) {
                console.log("client valid");
                clientValid = true
                $.getJSON("/api/navires/client/" + $("#clientInput").val(), function (data) {
                    var items = [];
                    $.each(data, function (key, navire) {
                        items.push("<option id='navire" + navire.codeNavire + "' value = '" + navire.codeNavire + "'>" + navire.nomNavire + "</option>");
                    });
                    if (items.length > 0) {
                        $("#navireInput").attr("disabled", false);
                    }

                    $("<datalist/>", {
                        "id": "navires",
                        html: items.join("")
                    }).appendTo("#navires-datalist");
                });
            } else {
                console.log("client invalid");
                createAlert("Le client n'est pas valide", "#bulletinAddContainer");
                clientValid = false;
            }




        }
    });

    $("#navireInput").change(function () {
        if ($("#navireInput").val() == "") {
            $("#navireNameText").text("");
        } else {
            var val = $("#navireInput").val();
            var obj = $("#navires").find("option[value='" + val + "']");
            let option = $("#navire" + $("#navireInput").val());
            $("#navireNameText").text(option.text());
            if (obj != null && obj.length > 0) {
                console.log("navire valid");
                navireValid = true;
            } else {
                navireValid = false;
                createAlert("Le navire n'est pas valide", "#bulletinAddContainer");
                console.log("navire invalid");
            }
        }
    });


    $(".prestation").each(function (i) {
        $(this).change(function () {
            var numero = $(this).attr('numero');
            if ($(this).val() == "") {
                $("#prestation" + numero + "Text").text("");
            } else {
                var val = $(this).val();

                var obj = $("#prestations").find("option[value='" + val + "']");
                let option = $("#prestation" + $(this).val());
                $("#prestation" + numero + "Text").text(option.text());

                if (obj != null && obj.length > 0) {
                    console.log("prestation valid");
                    console.log(numero);
                    navireValid = true;

                } else {
                    navireValid = false;
                    createAlert("La prestation n'est pas valide", "#bulletinAddContainer");
                    console.log("prestation invalid");
                }
            }
        });
    });

    $("#dateSortieInput").change(function () {
        console.log("date changed")
        if ($("#dateEntreeInput").val() == "" || $("#dateSortieInput").val() == "") {
            console.log("enter the dates please");
        } else {
            console.log("checking the dates");
            var dateEntree = new Date($("#dateEntreeInput").val());
            var dateSortie = new Date($("#dateSortieInput").val());
            if (dateEntree > dateSortie) {
                createAlert("the first date is bigger then the second", "#bulletinAddContainer");
                $("#dateSortieInput").val("");
            }
        }
    });

    $("#dateEntreeInput").change(function () {
        console.log("date changed")
        if ($("#dateEntreeInput").val() == "" || $("#dateSortieInput").val() == "") {
            console.log("enter the dates please")
        } else {
            console.log("checking the dates from date entree input");
            var dateEntree = new Date($("#dateEntreeInput").val());
            var dateSortie = new Date($("#dateSortieInput").val());
            if (dateEntree > dateSortie) {
                createAlert("the first date is bigger then the second", "#bulletinAddContainer");
                $("#dateEntreeInput").val("");
            }
        }
    });

});


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