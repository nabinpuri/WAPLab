/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";
(function(){
    var listOfObjects = [];
    window.onload=pageLoad;
    var txtName;
    var txtDeposit;
    //module account
    var account= (function(){
        var acountName="";
        var deposit="";
        function setAccountName(name){
            acountName=name;
        }
        
        function setDeposit(amount){
            deposit=amount;
        }
        
        var object= {
            create: function(name,deposit){
                setDeposit(deposit);
                setAccountName(name);
                
            },
            getName:function(){
                return acountName;
            },
            getDeposit:function(){
                return deposit;
            }
        };

        return object;
    });

    function displayNew(){
        var text= document.getElementById("text");
        var txt="";
        var i=0;
        for(i=0;i<listOfObjects.length;i++){
            var obj= listOfObjects[i];
            txt+="\n Account Name:"+obj.getName()+"     Balance:"+obj.getDeposit();
        }
        text.value=txt;
    }
  
    var handler= (function(){
        return function(){
            var newObject=account();
            if((txtName.value!="")&&(txtDeposit.value!="")){
                newObject.create(txtName.value,txtDeposit.value);
                listOfObjects.push(newObject);
                displayNew();
                clear();
            }
            else{
                alert("please fill all fields");
            }
            
        };
    })();
    function clear(){
        txtName.value="";
        txtDeposit.value="";
    }
 
    function pageLoad() {
        txtName= document.getElementById("name");
        txtDeposit= document.getElementById("deposit");
      document.getElementById("create").onclick = handler;
    }
})();
    
