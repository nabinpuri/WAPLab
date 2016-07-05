/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var rudyTimer= (function(){
    var timer = null;  // stores ID of interval timer
    function rudy() {   // called each time the timer goes off
      document.getElementById("output").innerHTML += " Rudy!";
    }
    
     var delayMsg2= (function() {
      if (timer == null) {
          
        timer = setInterval(rudy, 1000);
      } else {
        clearInterval(timer);
        timer = null;
      }
    });
    
    return delayMsg2;
})();

