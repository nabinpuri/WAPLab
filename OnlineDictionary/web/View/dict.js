/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";
(function(){
    var txtView=$('#txtView');
    
    $(document).ready(function(){
        $('#btnLookUp').click(lookUp);
        $( "input#word" ).autocomplete({
               source: function(request, resolve) {
                 var find=$("#word" ).val();
                  console.log(find);
                 var words=[];
                 if(find.length>1){
                      $.ajax({
                    type:'GET',
                    data:{
                        "findby":find
                    },
                    url:'dictServlet',
                    dataType: 'json',
                    error: function (xhr, ajaxOptions, thrownError) {
                       // alert(xhr.status);
                        alert(thrownError);
                    },
                    success:function(data){
                        $.each(data, function(i, obj) {
                            words.push(obj.word);
                        });
                       // console.log(words);
                        resolve(words);
                        //console.log(availableTags);
                    }

                });
                }
                
        
        },
        select:function(){
            lookUp();
        },
        //minLength:10,
       autoFocus:true
    });
          
    });
    
    var lookUp=function(){
        var wordToFind=$("#word").val();
        console.log(wordToFind);
        //alert("lookUp");
        if(wordToFind!=""){
            $.ajax({
            type: 'POST',
            url:'dictServlet',
            dataType: 'json',
            data: {
                "word" : wordToFind // will be accessible in $_POST['data1']
             },
            error: function (xhr, ajaxOptions, thrownError) {
               // alert(xhr.status);
                alert(thrownError);
            },
            success:function(data){
                //console.log(data.length);
                    var txt="";
                    var count=1;
                    if(data.length<1){
                        
                        alert("No search result found");
                        $('#display').html("");
                        //$('textarea#txtView').text("");
                        return;
                    }
                    $.each(data, function(i, obj) {
                        txt+="<li>"+"("+obj.type+") ::"+obj.define+"</li><br>";
                        //txt+="\n\n"+count+"("+obj.type+") "+"::"+obj.define;
                        //count++;
                    //console.log(obj.type);                             
                    });
                    console.log(txt);
                    $('#display').html(txt);
                   // $('textarea#txtView').text(txt);
                }
            });
        }
        
        
    };
})();


