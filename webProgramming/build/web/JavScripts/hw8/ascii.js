/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";
window.onload = pageLoad;
var timer;
var speed=250;
function pageLoad() {
  document.getElementById("btnStart").onclick= start;
 document.getElementById("btnStop").onclick= stop;
 document.getElementById("btnStop").disabled = true;
 document.getElementById("ddAnimation").onchange= animationChanged;
 document.getElementById("ddSize").onchange= sizeChanged;
 document.getElementById("chkSpeed").onchange= turboSpeedChanged;
// document.getElementById("chkSpeed").disabled = true;
  //document.getElementById("bigger").onclick = biggerDecoration;
}

function start(){
    document.getElementById("btnStop").disabled = false;
    var textValue=document.getElementById("text").value;
    document.getElementById("ddAnimation").disabled=true;
    //document.getElementById("chkSpeed").disabled = false;
    animate(textValue);
    
}
function animate(text){
    var frames=text.split("=====\n");
    var i=0;
   var run =function() {
        if(i>=frames.length){
            i=0;
        }
        document.getElementById("text").value=frames[i];
        i++;
        clearInterval(timer);
       timer= setInterval(run, speed);
    };
    timer=setInterval(run, speed);
}
function stop(){
    clearTimeout(timer);
    document.getElementById("ddAnimation").disabled=false;
    animationChanged();
    document.getElementById("btnStop").disabled = true;
    //document.getElementById("chkSpeed").disabled = true;
}
function animationChanged(){
    var choice=document.getElementById("ddAnimation");
    var text=document.getElementById("text");
    var value=choice.options[choice.selectedIndex].value;
    switch(value){
        case "Exercise":
            text.value=EXERCISE;
            break;
         case "Juggler":
             text.value=JUGGLER;
            break;
         case "Bike":
             text.value=BIKE;
            break;
         case "Dive":
             text.value=DIVE;
            break;
         case "Custom":
             text.value=CUSTOM;
            break;
        default:
            text.value=BLANK;
             break;
    }
}
function turboSpeedChanged(){
    
    if(document.getElementById('chkSpeed').checked){
        speed=50;
    }
    else{
        speed=250;
    }
    //stop();
    //start();
}
function sizeChanged(){
    var choice=document.getElementById("ddSize");
    var text=document.getElementById("text");
    var value=choice.options[choice.selectedIndex].value;
    text.style.fontSize=value;
}
