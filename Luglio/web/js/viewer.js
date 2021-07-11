/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const keywords = ['gol', 'gollasso', 'sensazionale'] ;
var refreshRate;
var messageCount;

function readAll() {
    window.location.replace("/Luglio/Viewer?index=0");
}

function refresh() {
    setTimeout(function(){
        let url = "/Luglio/Viewer";
        const newRate = $('#rate').val();
        if (newRate) {
            url += "?rate=" + newRate;
        } else {
            url += "?rate=" + refreshRate;
        }
        console.log(url)
        window.location.replace(url);
    }, refreshRate * 1000);
}

function highlight () {
    for (let i = 0; i < messageCount; ++i) {
        for (const keyword of keywords) {
            let text = $(`#${i}`).html().toLowerCase();
            if (text.includes(keyword)) {
                $(`#${i}`).addClass('table-success')
            }
        }
    }
}