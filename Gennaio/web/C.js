/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var rentsList = [];
var kind;

function changeKind() {
    window.location.replace("/Gennaio/B");
}

function show(clicker) {
    console.log(rentsList);
    rentsList.forEach((rent) => {

        if (clicker.textContent === rent.name) {
            $('#rName').html(rent.name);
            $('#rPrice').html(rent.price + " euro");
            $('#rScore').html(rent.score + " su 10");
            setExtra(rent.extra);
            $('#rImage').prop('src', `img/${rent.image}`);
            $('#detailTable').removeClass('hidden');
        }
    })
}

function setExtra(val) {
    switch (kind) {
        case 'Pensione':
            setPensione(val);
            break;
        case 'Albergo':
            setAlbergo(val);
            break;
        case 'Appartamento':
            setAppartamento(val);
            break;
    }
}

function setPensione(val) {
    $('#hExtra').html('Trattamento');
    switch (val) {
        case '1':
            $('#rExtra').html('Solo prima colazione');
            break;
        case '2':
            $('#rExtra').html('Mezza pensione');
            break;
        case '3':
            $('#rExtra').html('Pensione completa');
            break;
    }
}

function setAlbergo(val) {
    $('#hExtra').html('Stelle');
    $('#rExtra').html(val);
}


function setAppartamento(val) {
    $('#hExtra').html('Posti disponibili');
    $('#rExtra').html(val);
}