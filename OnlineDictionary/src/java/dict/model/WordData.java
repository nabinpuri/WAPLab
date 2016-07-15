/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dict.model;

/**
 *
 * @author Nabin
 */
public class WordData {
    String definition;
    String type;
   public  WordData(String meanings,String types){
        definition=meanings;
        type=types;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String Meaning) {
        this.definition = Meaning;
    }
}
