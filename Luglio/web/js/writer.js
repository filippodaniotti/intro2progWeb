/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function sendMessage() {
    const url = "AddMessage";

    let message = $('#message').val();
    const body = {
        message: message
    };

    $.post(url, body, function (data, status, xhr) {
        if (status == 'success') {
            console.log(data)
            if (data.close) {
                $('#message').remove();
                $('#sendButton').remove();
                $('#main').append("<h5>Webcast has been closed, you will be redirected...</h5>");
                setTimeout(function () {
                    window.location.replace('/Luglio');
                }, 2000);
            } else {
                $('#message').val('');
            }
        }
    });
}


