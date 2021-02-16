const keywords = ['gol', 'rigore', 'golasso', 'sensazionale'];


function highlight() {
    let rows = $('td.msg');
    let i = 1;
    console.log(rows);
    for (r of rows) {
        let s = r.innerHTML;
        for (w of keywords) {
            if (s.toLowerCase() === w) {
                $('#' + i).addClass('table-info');
            }
        }
        ++i;
    }
}

function polling () {
    window.location.reload();
}

function changeTimeout () {
    let newRr = $('#textbar').val();
    console.log(newRr);
    let data = { rate: newRr };
    let url = 'GetRR';
    $.post(url, data, function(data, status) {
       if (status === 'success') {
           $('#textbar').val('');
       } else {
           console.log('failed to send');
       }
    });
}

function setRR() {
    let url = 'GetRR';
    $.get(url, function(data, status) {
       if (status === 'success') {
           let newRr = data.rate;
            timeout = parseInt(newRr) * 1000;
            console.log(timeout);
            if (!timeout)
                setTimeout(polling, 30000);
            else
                setTimeout(polling, timeout);
       } else {
           console.log('err');
       }
    });
}