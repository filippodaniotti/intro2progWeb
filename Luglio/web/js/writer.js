function sendMsg() {
    let msg = $('#textbar').val();
    let data = {
        message: msg
    };
    let url = 'addMessage';
    
    $.post(url, data, function(data, status) {
       if (status === 'success') {
           $('#textbar').val('');
       } else {
           console.log('failed to send');
       }
    });
}