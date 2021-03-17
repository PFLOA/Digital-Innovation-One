let limits = gets().split(" ");
let a = limits[0];
let b = limits[1];
let q = 0;
if(-1000 <= a){
  if(b < 1000){
      let r = a%b; // -7 = -3 x 2 + 1  
      
      if(r < 0){
        r = r + Math.abs(b);
      }
      
      q = (a - r)/b;  // r + q x d = D
      console.log(q + " " + r);
  }
}  
