/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jspIntro.Classes;

/**
 *
 * @author 984984
 */
public class RasdioState {
    String yesCheck;
    String noCheck;
    public RasdioState(){
        yesCheck="False";
        noCheck="False";
    }

    public String getYesCheck() {
        return yesCheck;
    }

    public void setYesCheck(String yesCheck) {
        this.yesCheck = yesCheck;
    }

    public String getNoCheck() {
        return noCheck;
    }

    public void setNoCheck(String noCheck) {
        this.noCheck = noCheck;
    }
}
