let entradas = gets().split(" ");

let tempo = entradas[0]; //horas
let velocidade = entradas[1]; // km/h

let distancia = tempo * velocidade;
let gastoCombustivel = distancia/12;

console.log(parseFloat(gastoCombustivel).toFixed(3));