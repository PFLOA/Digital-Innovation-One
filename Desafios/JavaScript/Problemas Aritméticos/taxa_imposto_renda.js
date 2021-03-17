let valor = parseFloat(gets()).toFixed(2);
let valorImposto = 0;
let valorTabela8 = 0;
let valorTabela18 = 0;
let valorTabela28 = 0;
let imposto = 0;
let G = 0;

if(valor <= 2000.00)
{
  console.log("Isento");
}
else
{
  valorImposto = valor - 2000; // 4520 - 2000 = 2520
  
  if(valorImposto > 1000)
  {  //2520 > 0
    valorTabela8 = 1000 * 0.08;   // 1000 * 0.08 = 80,00
    G = valorImposto - 1000;  // 2520 - 1000 = 1520
    
    if(G > 1500)
    {
      valorTabela18 = 1500 * 0.18; // 1500 * 0.18 = 270,00
      G = G - 1500;// 1520 - 1500 = 1520
      
      if(G > 0)
      {
        valorTabela28 = G * 0.28; // 20 * 0,28 = 5,60
      }
    }
    else
    {
      valorTabela18 = G * 0.18; // (1000 - 998) * 0,18 = 0,36
    }
  }
  else
  {
    valorTabela8 = valorImposto * 0.08;
  }
  imposto = valorTabela8 + valorTabela18 + valorTabela28;
  console.log("R$ " + parseFloat(imposto).toFixed(2));
}