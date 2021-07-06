/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function wallclock() {
    let currentTime = $('#time').text();
    $('#time').text(parseInt(currentTime)-1);
    console.log(currentTime);
}

function isInt() {
    let offer = $('#offer').text();
    if (offer === "a") {
        $('#error').html("Inserisci un numero!")
    }
}