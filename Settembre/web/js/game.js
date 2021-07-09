/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function sendWord(gameKey, user) {
    let url = `/Settembre/AddWord?key=${gameKey}&user=${user}`;
    let word = $('#word').val();
    $('#word').val('');
    url += `&word=${word}`;
    $.get(url, function (data, status, xhr) {
        if (status == 'success') {
            console.log(status)
            console.log(data);
            if (data.endGame) {
                $('#wordField').html(`<h3>${data.msg}${word}!</h3>`);
                setTimeout(function () {
                    window.location.replace(`/Settembre/Reset?all=${gameKey}`);
                }, 3000);
            } else {
                $('#wordList').append(`<li>${word}</li>`);
            }
        }
    });
}

