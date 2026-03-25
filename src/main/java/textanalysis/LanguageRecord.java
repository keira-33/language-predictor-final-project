/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package textanalysis;

/**
 *
 * @author kfrey
 */
public class LanguageRecord {
    private String textCollection;
    private String langCode;
    
    
    public LanguageRecord(String langCode){
        this.langCode = langCode; 
    }
    
    //setters:
    public void setTextCollection(String text){
        this.textCollection = text;
    }
    
    //getters:
    public String getLangCode(){
        return this.langCode;
    }
}
