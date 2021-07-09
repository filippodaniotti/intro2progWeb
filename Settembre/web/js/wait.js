/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var user;

function refresh() {
    $.get("/Settembre/CheckIfReadyToStart?user="+user,
            function (data, status, xhr) {
                if (status == 'success') {
                    let json = JSON.parse(data);
                    console.log(json);
                    if (json.ready === true) {
                        window.location.replace('/Settembre/game.jsp');
                    } else {
                        let counter = $('#counter').text();
                        $('#counter').html((+counter) + 1);
                        setTimeout(refresh, 2000);
                    }
                }
            });
}