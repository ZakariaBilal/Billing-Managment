var counter = 0;

function generateButton(type = "Condition") {
    return $('<div/>', {
        'class': 'row',
        'id': 'buttons'
    }).append($('<div/>', {
        'class': 'col'
    }).append($('<input/>', {
        'class': 'btn btn-info mb-3',
        'type': 'button',
        'value': 'ajouter Tranche',
        'onClick': 'addInput' + type + '();',
        'id': 'addingButton'
    }))).append($('<div/>', {
        'class': 'col'
    }).append($('<input/>', {
        'class': 'btn btn-danger mb-3',
        'type': 'button',
        'value': 'supprimer Tranche',
        'onClick': 'deleteInput();',
        'id': 'deletingButton'
    })));
}

function generateConditionTranche() {
    var value;
    if (counter == 0) {
        value = "0";
    } else {
        value = "";
    }
    var temp = $('<div/>', {
        'class': 'row',
        'id': 'tranche' + counter
    }).append($('<div/>', {
        'class': 'col'
    }).append($('<input/>', {
        'class': 'form-control mb-4',
        'required': 'true',
        'type': 'number',
        'name': 'tranches[' + counter + '].minCondition',
        "value": value,
        'placeholder': 'min Condition'
    }))).append($('<div/>', {
        'class': 'col'
    }).append($('<input/>', {
        'class': 'form-control mb-4',
        'required': 'true',
        'type': 'number',
        'name': 'tranches[' + counter + '].montant',
        'placeholder': 'montant'
    })));
    counter++;
    return temp;
}

function generateQuantite() {
    var temp = $('<input/>', {
        'class': 'form-control mb-4',
        'required': 'true',
        'type': 'number',
        'name': 'tranches[0].montant',
        'placeholder': 'montant'
    });
    return temp;
}

function generateJourTranche() {
    var value;
    if (counter == 0) {
        value = "0";
    } else {
        value = "";
    }
    var temp = $('<div/>', {
        'class': 'row',
        'id': 'tranche' + counter
    }).append($('<div/>', {
        'class': 'col'
    }).append($('<input/>', {
        'class': 'form-control mb-4',
        'required': 'true',
        'type': 'number',
        "value": value,
        'name': 'tranches[' + counter + '].minJour',
        'placeholder': 'min Jour'
    }))).append($('<div/>', {
        'class': 'col'
    }).append($('<input/>', {
        'class': 'form-control mb-4',
        'required': 'true',
        'type': 'number',
        'name': 'tranches[' + counter + '].montant',
        'placeholder': 'montant'
    })));
    counter++;
    return temp;
}

function generateTjbJourTranche() {
    var temp = $('<div/>', {
        'class': 'row',
        'id': 'tranche' + counter
    }).append($('<div/>', {
        'class': 'col'
    }).append($('<input/>', {
        'class': 'form-control mb-4',
        'required': 'true',
        'type': 'number',
        'name': 'tranches[' + counter + '].minJour',
        'placeholder': 'min Jour'
    }))).append($('<div/>', {
        'class': 'col'
    }).append($('<input/>', {
        'class': 'form-control mb-4',
        'required': 'true',
        'type': 'number',
        'name': 'tranches[' + counter + '].minCondition',
        'placeholder': 'Condition'
    }))).append($('<div/>', {
        'class': 'col'
    }).append($('<input/>', {
        'class': 'form-control mb-4',
        'required': 'true',
        'type': 'number',
        'name': 'tranches[' + counter + '].montant',
        'placeholder': 'montant'
    })));
    counter++;
    return temp;
}

function generateHoursTranche() {
    return $('<div/>').append($('<div/>', {
        'class': 'row'
    }).append($('<div/>', {
        'class': 'col'
    }).append($('<input/>', {
        'class': 'form-control mb-4',
        'required': 'true',
        'type': 'number',
        'name': 'tranches[0].minJour',
        'placeholder': 'min demi heures',
        'value': '0',
        'disabled': '1'
    }))).append($('<div/>', {
        'class': 'col'
    }).append($('<input/>', {
        'class': 'form-control mb-4',
        'required': 'true',
        'type': 'number',
        'name': 'tranches[0].montant',
        'placeholder': 'montant demi heure'
    })))).append($('<div/>', {
        'class': 'row'
    }).append($('<div/>', {
        'class': 'col'
    }).append($('<input/>', {
        'class': 'form-control mb-4 disabled',
        'required': 'true',
        'type': 'number',
        'name': 'tranches[1].minJour',
        'placeholder': 'min heure',
        'value': '1',
        'disabled': '1'
    }))).append($('<div/>', {
        'class': 'col'
    }).append($('<input/>', {
        'class': 'form-control mb-4',
        'required': 'true',
        'type': 'number',
        'name': 'tranches[1].montant',
        'placeholder': 'montant heure'
    }))));



}

$(document).ready(function () {
    init();
    $("#type").change(function () {
        $("#tarifs").html("");
        counter = 0;
        switch ($("#type").val()) {
            case "quantite":
                $("#tarifs").append(
                    generateQuantite()
                );
                break;
            case "tjbTranche":
                $("#tarifs").append(generateConditionTranche()).append(generateConditionTranche()).append(generateButton());
                break;
            case "heures":
                $("#tarifs").append(generateHoursTranche());
                break;
            case "jourTranche":
                $("#tarifs").append(generateJourTranche()).append(generateJourTranche()).append(generateButton("Jours"));
                break;
            case "tjbJour":
                $("#tarifs").append(generateTjbJourTranche()).append(generateTjbJourTranche()).append(generateButton("TjbJour"));
                break;
            case "quantiteTranche":
                $("#tarifs").append(generateConditionTranche()).append(generateConditionTranche()).append(generateButton());
                break;
            case "longueurNavire":
                $("#tarifs").append(generateConditionTranche()).append(generateConditionTranche()).append(generateButton());
                break;

            default:
                break;
        }

    })

    $("#prestationForm").submit(function () {
        return true;
    })
})

function deleteInput() {
    if (counter > 2) {
        $("#tranche" + (counter - 1)).remove();
        counter--;
    }
}

function addInputCondition() {
    $("#buttons").before(generateConditionTranche());
}

function addInputJours() {
    $("#buttons").before(generateJourTranche());
}

function addInputTjbJour() {
    $("#buttons").before(generateTjbJourTranche());
}

function init() {
    switch ($("#type").val()) {
        case "quantite":
            $("#tarifs").append(
                generateQuantite()
            );
            break;
        case "tjbTranche":
            $("#tarifs").append(generateConditionTranche()).append(generateConditionTranche()).append(buttons);
            console.log("the counter is " + counter);
            break;

        default:
            break;
    }
}