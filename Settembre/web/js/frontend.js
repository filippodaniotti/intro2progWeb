function refresh() {
    let url = "CheckIfReadyToStart?pic=" + $.urlParam('pic');
    $.get(url, function(response, status, xhr){
        if (status === 'success') {
            if (response.ready) {
                window.location.href = 'game.jsp?pic=' + response.pic;
            } else {
                let sCount = $('#counter').text();
                let count = parseInt(sCount);
                ++count;
                $('#counter').text(count);
            }
        } else {
            console.log("err");
        }
    });
    setTimeout(refresh, 2000);
}

function loadImage(pic) {
    let src = '"images/' + pic + '.png"';
    $('#image').append('<img src=' + src + 'class="image-fluid" width="500px" height="auto" alt="image"></img>');
}

function addWord() {
    let word = $('#textbar').val();
    $('#words').append('<tr><td>' + word + '</td></tr>');
    
    let url = `NewWord?word=` + word;
    $.get(url, function(response, status, xhr) {
        if (status === 'success') {
            if (response.win) {
                endGame();
            } else {
                $('#textbar').val('');
            }
        } else {
            console.log('err');
        }
    });
}

function endGame() {
    $('#sender').empty();
    $('#sender').append('<h3>Il gioco è finito, vittoria!</h3>');
}

function unbind() {
    let url = 'EndGame';
    $.get(url, function() { });
}

function checkWin() {
    let url = "CheckWin";
    $.get(url, function(response, status, xhr){
        if (status === 'success') {
            if (response.win) {
                endGame();
            }
        } else {
            console.log('err');
        }
    });
    setTimeout(checkWin, 2000);
}

$.urlParam = function(name){
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    return results[1] || 0;
};