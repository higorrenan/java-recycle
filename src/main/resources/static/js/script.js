let contador = 1;

setInterval( function(){
    document.getElementById('slide' + contador).checked = true;
    contador++;

    if(counter > 4 ) {
        contador = 1;
    }
}, 3000 );