let nota = "0 3.5 11.0 10.0".split(" ");
let notas = [];
let media = 0;


while (true) {

    nota.map(element => {

        if (element < 0 || element > 10) {
            console.log("nota invalida");
        } else {
            notas.push(element);
            console.log(notas);
        }

        if (notas.length == 2)
        break;
    });

    if (notas.length == 2)
        break;
}

media = (notas[0] + notas[1]) / 2;
console.log("media = ", media);