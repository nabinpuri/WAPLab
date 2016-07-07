/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";
(function(){
    var state="notStarted";
    
   $(document).ready(function(){
      // alert("inside reazdy");
       $(".boundary").mouseover(looseCheck);
       $("#end").mouseover(endReached);
       $("#start").click(started);
       $("#maze").mouseleave(looseCheck);

   });

   var endReached=function(){
       if(state==="started"){
           state="won";
           $("#status").text("you win");
           //alert("you win");
       }
   };

   var started= function(){
       state="started";
       $("#status").text("Started");
       $(".boundary").removeClass("youlose");
   };


   var looseCheck= function(){
       if(state==="started"){
           $("#status").text("you loose");
           $(".boundary").addClass("youlose");
           state="error";
       }
   };
})();



