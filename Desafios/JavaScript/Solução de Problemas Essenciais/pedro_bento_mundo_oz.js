var entrada = gets();
var joias = [];

joias.push(entrada);

while (true) {

    entrada = gets();

    if (entrada == "")
        break;

    var joiaNoArray = joias.find(joia => joia == entrada);

    // O metodo find() retorna o valor do primeiro elemento  
    // do array que satisfizer a função de teste provida. Caso contrario, undefined é retornado.

    if (joiaNoArray == undefined) {
        joias.push(entrada);
    }
}

console.log(joias.length);