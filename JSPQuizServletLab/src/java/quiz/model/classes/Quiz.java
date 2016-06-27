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
        "3,1,4,1,5",
        "1,1,2,3,5",
        "1,4,9,16,25",
        "2,3,5,7,11",
        "1,2,8,4,16"
    };
    
    private static final int[] answers={
        9,8,36,13,32
    };
    
    private int currentQuestionNo;
    private int currentScore;
    private int currentTryNo;

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
    
    public void verifyAnswer(int answer){
        if(answer==answers[currentQuestionNo-1]){
            currentScore++;
        }
    }
    
    public String getNextQuestion(){
        currentQuestionNo++;
        return questions[currentQuestionNo-1];
    }
    
}
