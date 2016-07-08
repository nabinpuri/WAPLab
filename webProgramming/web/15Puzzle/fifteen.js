/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    $(document).ready(function(){
      init();
      $('.puzzlepiece').click(movePiece);
  });
   var emptySpace= (function(){
        var x;
        var y;
        var row;
        var column;
        var object= {
            set: function(xPos,yPos,rowNo,colNo){
                x=xPos;
                y=yPos;
            },
            getX:function(){
                return x;
            },
            getY:function(){
                return y;
            },
            getRow:function(){
                return row;
            },
            getColumn:function(){
                return column;
            }
        };
        return object;
    })();
    
    init = function() {
        var puzzleArea = $('#puzzlearea');
        var divs = puzzleArea.find("div");
        var i=0;
        // initialize each piece
        
        for (i=0; i< divs.length; i++) {
            var div = $(divs[i]);

            // calculate x and y for this piece
            var x = ((i % 4) * 100) ;
            var y = (Math.floor(i / 4) * 100) ;

            // set basic style and background
            div.addClass("puzzlepiece");
            div.css({left:x + 'px',top: y + 'px',
                backgroundImage:'url("img/background.jpg")',
                backgroundPosition:-x + 'px ' + (-y) + 'px'});

            // store x and y for later
            div.data("x",x);
            div.data("y",y);
            
            var row=i % 4;
            var column=Math.floor(i / 4);
            
            div.data("row",row); 
            div.data("column",column); 

       }
       //alert(div);
       x=((i % 4) * 100) ;
       y = (Math.floor(i / 4) * 100) ;
       emptySpace.set(x,y);
       
    };
    
    var movePiece= function(){
        //just swap empty with clicked one
        var tempX=$(this).data("x"); 
        var tempY=$(this).data("y");
        var temRow=$(this).data("row");
        var temCol=$(this).data("column");
        
        if(checkIfNeighbourEmpty(temRow,temCol)){
        $(this).data("x",emptySpace.getX());
        $(this).data("y",emptySpace.getY());
        $(this).data("row",emptySpace.getRow());
        $(this).data("column",emptySpace.getColumn());
        
        $(this).css({left:emptySpace.getX() + 'px',top: emptySpace.getY() + 'px',
                backgroundImage:'url("img/background.jpg")'});
        
        emptySpace.set(tempX,tempY,temRow,temCol);
        }
        
    };
    
    var checkIfNeighbourEmpty= function(thisRow,thisCol){
        var emptyRow=emptySpace.getRow();
        var emptyCol=emptySpace.getColumn();
        
        if((thisRow==emptyRow+1)||(thisRow==emptyRow-1)){
            return true;
        }
        if((thisCol==emptyCol+1)||(thisCol==emptyCol-1)){
            return true;
        }
        
        return false; 
    };
})();
 
