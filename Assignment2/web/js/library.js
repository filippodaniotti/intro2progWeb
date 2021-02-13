function getDetails() {
    var url = `getInfo?title=Fosca`;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            json = JSON.parse(this.response);
            console.table(json);
        }
    }
    xhhtp.open("GET", url, true);
    xhhtp.send();
}