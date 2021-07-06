/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const bomb = "-1"

function clickCell(i, j) {
    let url = "getValue"
    let body = {
        x: i,
        y: j
    }
    $.post(url, body, function (response, status, xhr) {
        if (status == 'success') {
            if (response.value == "board not found") {
                resetGame();
            } else {
                let cell = `${i}${j}`
                if (response.value === bomb) {
                    $(`#${cell}`).html("&#128163;");
                    $(`#${cell}`).addClass("table-danger")
                    window.alert('You lose');
                    resetGame();
                } else {
                    $(`#${cell}`).html(response.value);
                    $(`#${cell}`).addClass("table-success");
                }
            }
        }
    })
}

function resetGame() {
    let url = 'resetGame'
    $.get(url, function (response, status, xhr) {
        if (status == 'success') {
            window.location.reload()
        }
    });
}

function handleTestButton() {
    let x = $('#row').val() - 1;
    let y = $('#column').val() - 1;
    clickCell(x, y)
}

function checkWin() {

}