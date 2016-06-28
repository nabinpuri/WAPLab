/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.model.classes;

/**
 *
 * @author Nabin
 */
public class Quiz {
    private static final int TOTALQUESTION=5;
    private static final String[] questions={
        "[ 3,1,4,1,5",
        "[ 1,1,2,3,5",
        "[ 1,4,9,16,25",
        "[ 2,3,5,7,11",
        "[ 1,2,8,4,16"
    };
    
    private static final int[] answers={
        9,8,36,13,32
    };
    
    private int currentQuestionNo;
    private int currentScore;
    private int currentTryNo;
    private boolean quizEnded;

    public boolean isQuizEnded() {
        return quizEnded;
    }

    public void setQuizEnded(boolean quizEnded) {
        this.quizEnded = quizEnded;
    }
    private static final String hint[]={
        "It is Pi Number.",
        "Fibanocci...",
        "Square....",
        "Prime Numbers...",
        "Power of 2..."
    };

    public String getCurrentHint(){
        return hint[currentQuestionNo-1];
    }
    public int getCurrentTryNo() {
        return currentTryNo;
    }

    public void setCurrentTryNo(int currentTryNo) {
        this.currentTryNo = currentTryNo;
    }
    public Quiz(){
        this.currentQuestionNo=0;
        this.currentScore=0;
        currentTryNo=0;
        quizEnded=false;
    }

    public int getCurrentQuestionNo() {
        return currentQuestionNo;
    }

    public void setCurrentQuestionNo(int currentQuestionNo) {
        this.currentQuestionNo = currentQuestionNo;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }
    
    public boolean hasNext(){
        return currentQuestionNo < TOTALQUESTION ? true:false;
    }
    
    public boolean verifyAnswer(int answer){
        if(isQuizEnded()){
           return true;
        }
        if(answer==answers[currentQuestionNo-1]){
            if(currentTryNo==0){
                currentScore+=10;
            }  
            else if(currentTryNo==1){
                currentScore+=5;
            }
            else if(currentTryNo==2){
                currentScore+=2;
            }  
            currentTryNo=0;
            return true;
        }
        else{
            currentTryNo++;
            return false;
        }
        
    }
    
    public String getNextQuestion(){
        currentQuestionNo++;
        return questions[currentQuestionNo-1];
    }
    public String getCurrentQuestion(){
        //currentQuestionNo++;
        return questions[currentQuestionNo-1];
    }
    public int getCorrectAnswer(){
        return answers[currentQuestionNo-1];
    }
    
    public String getGrade(){
        if(currentScore>45){
            return "A";
        } if(currentScore>=35&&currentScore<=44){
            return "B";
        }
         if(currentScore>=25&&currentScore<=34){
            return "C";
        }
         else{
             return "NC";
         }
        
    }
    
}
