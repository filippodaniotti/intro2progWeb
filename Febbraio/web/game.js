/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var fixedCells = [];
var fixedCellsValues = {};

function checkInput(x, y) {
    let text = $(`#${x}${y}`).val();
    let textInt = parseInt(text);
    if (!isValidInt(textInt)) {
        $(`#${x}${y}`).val('');
    }
}

function isValidInt(value) {
    return !value || (value > 0 && value < 10);
}

function initialize() {
    for (let i = 1; i < 10; ++i) {
        for (let j = 1; j < 10; ++j) {
            if (fixedCells.includes(`${i}${j}`)) {
                let input = $(`#${i}${j}`);
                input.prop('disabled', 'disabled');
                input.val(fixedCellsValues[`${i}${j}`]);
                input.addClass('black');
            }
        }
    }
}

function checkCell() {
    let row = $('#row').val();
    let col = $('#col').val();

    if (isValidInt(row) && isValidInt(col)) {
        const url = `/Febbraio/GetValue?id=${getUrlParam('id', '1')}&x=${row}&y=${col}`;
        $.get(url, function(data, status, xhr) {
            if (status == 'success') {
                let msg = "";
                let sol = data.value;
                let current = $(`#${row}${col}`).val();
                console.log(sol, current)
                if (sol == current) {
                    msg += "Il valore nella cella selezionata è giusto";
                    $(`#${row}${col}`).addClass('red');
                    $(`#${row}${col}`).prop('disabled', 'disabled');
                } else {
                    msg += "Il valore nella cella selezionata è sbagliato";                    
                }
                window.alert(msg);
            }
        })
    }
}

function getUrlParam(parameter, defaultvalue) {
    var urlparameter = defaultvalue;
    if (window.location.href.indexOf(parameter) > -1) {
        urlparameter = getUrlVars()[parameter];
    }
    return urlparameter;
}

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (m, key, value) {
        vars[key] = value;
    });
    return vars;
}
