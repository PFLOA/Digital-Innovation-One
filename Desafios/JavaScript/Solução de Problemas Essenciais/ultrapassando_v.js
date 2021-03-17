// A função gets é implementada dentro do sistema para ler as entradas(inputs) dos dados
let R = parseInt(gets()); 
let V = parseInt(gets()); 


while (R >= V) {
    V = parseInt(gets());
}

var inicial = R;
var i = 1;

while (R <= V){
    i++;
    inicial++;
    R = R + inicial;
}

console.log(i);