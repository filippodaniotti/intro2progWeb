var name;
const bomb = "-1";

function clickCell(i, j) {
    let url = `Cell?row=${i}&col=${j}`;
    $.get(url, function(response, status, xhr) {
        if (status == 'success')
            console.log(response.value);
            showCell(response.value, i, j);
        if (status == 'error')
            console.log("Error: " + xhr.status + ": " + xhr.statusText);
    });
}

function showCell(value, i, j) {
    let cell = `#cell_${i}_${j}`;

    if (value == bomb) {
        $(cell).html("&#128163;");
        $(cell).removeClass("table-light");
        $(cell).addClass("table-danger");
        setTimeout(() => {
            if (confirm("Hai perso! Vuoi fare una nuova partita?")) {
                window.location.assign("GameInit?name="+name);
            } else {
                window.location.assign("index.html");
            }
        }, 500);
    } else {
        $(cell).text(value);
        $(cell).removeClass("table-light");
        $(cell).addClass("table-success");
    }
}