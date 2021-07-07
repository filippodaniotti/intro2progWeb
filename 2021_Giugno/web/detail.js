/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var bestOffer;

function wallclock() {
    let currentTime = $('#time').text();
    if (parseInt(currentTime) > -1) {
        $('#time').text(parseInt(currentTime)-1);        
    } else {
        window.location.reload();
    }
}

function isInt() {
    let offer = $('#offer').val();
    if (!parseInt(offer)) {
        $('#error').html("Inserisci un numero!");
        $('#submitOffer').prop('disabled', true);
    } else if (offer <= bestOffer) {
        $('#error').html("La tua offerta dev'essere superiore a quella attuale!");
        $('#submitOffer').prop('disabled', true);
    } else {
        $('#error').html("");
        $('#submitOffer').prop('disabled', false);
    }
}

function update() {
    window.location.reload();
}