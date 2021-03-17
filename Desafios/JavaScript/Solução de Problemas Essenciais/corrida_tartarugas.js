var maior = 0;
var entrada = gets();
var tartarugas = gets().split(" ");

while (true) {

    if (entrada == "")
        break;

    tartarugas.map((numero) => {
        var inteiro = parseInt(numero, 10);
        if (inteiro > maior) {
            maior = inteiro;
        }
    });

    if (maior < 10) {
        console.log("1");
    } else if (maior < 20) {
        console.log("2");
    } else if (maior >= 20) {
        console.log("3");
    }

    entrada = gets();
    tartarugas = gets().split(" ");
}


