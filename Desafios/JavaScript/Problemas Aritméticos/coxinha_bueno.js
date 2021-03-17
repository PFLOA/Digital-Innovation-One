let line = gets().split(" ");
let H = parseInt(line[0]);
let P = parseInt(line[1]);
    
if (H >= 1) {
  if(P<=1000){
      let divisao = parseFloat(H/P).toFixed(2);
      console.log(divisao);
    }
}