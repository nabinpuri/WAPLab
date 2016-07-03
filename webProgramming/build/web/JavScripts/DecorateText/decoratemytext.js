/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function pageLoad() {
  document.getElementById("chkbling").onchange = blingClick;
  //document.getElementById("bigger").onclick = biggerDecoration;
}

function blingClick() {
    var text=document.getElementById("text");
    if(document.getElementById("chkbling").checked){
        text.style.fontWeight="bold";
        text.style.color="green";
        text.style.textDecoration="underline";
        document.body.style.backgroundImage="url('http://www.cs.washington.edu/education/courses/190m/CurrentQtr/labs/6/hundred-dollar-bill.jpg')";
        
    }
    else{
        text.style.fontWeight="normal";
        text.style.color="black";
        text.style.textDecoration="none";
        document.body.style.backgroundImage="";
    }
}

window.onload = pageLoad; 

function biggerDecoration(){
    setInterval(grow,500);
};

function grow(){
        var txtArea=document.getElementById('text');
	var size=parseInt(window.getComputedStyle(txtArea).getPropertyValue('font-size'));
	size +=2;
	txtArea.style.fontSize =size+"px";
}

function pigLatin(){
	var txtArea=document.getElementById('text');
	var words=txtArea.value;
	var wordList=words.trim().split(" ");
	var finalString="";
	wordList.forEach(function(item){
		if(item.charAt(0).toLowerCase()!="a" 
			&& item.charAt(0).toLowerCase()!="e" 
			&& item.charAt(0).toLowerCase()!="i" 
			&& item.charAt(0).toLowerCase()!="o" 
			&& item.charAt(0).toLowerCase()!="u"){
				finalString +=item.slice(1)+item.charAt(0)+"ay ";
		}else {
			finalString +=" "+item+"ay ";
		}

	txtArea.value=finalString;	
	})


}

function malkovitch(){
	var txtArea=document.getElementById('text');
	var words=txtArea.value;
	var wordList=words.trim().split(" ");
	var final="";
	wordList.forEach(function(item){
		if(item.length>=5) {
			final +=" Malkovich";
		}
		else {
			final +=" "+item;
		}
	})
	txtArea.value=final;

}
