/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var myfunc = function(a, x) {
return a * x;
};

function test(){
var x = myfunc(2, 3);
var y = myfunc;
alert(x);
alert(y(2,3));
};
function booyah1(){
    alert("BOOYAH!");
}
function booyah2(){
    setTimeout(booyah1, 2000);
}
function click1(){
    setTimeout(booyah1, 2000);
}
function click2(){
    setTimeout(booyah2(), 2000);
}



