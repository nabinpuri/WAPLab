/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 function calcTip() {
                //var subtotalElem = 
                //var tipElem = 
                var totalElem = document.getElementById('total');
                var subtotalElem = document.getElementById('subtotal');
                var tipElem = document.getElementById('tip');
                //var subtotal = 
                //var tip = 
                var subtotal= parseFloat(subtotalElem.value);
                var tips= parseFloat(tipElem.value);
                var total = (tips/100)*subtotal+subtotal;
                totalElem.innerHTML = '$' + total;
        }

