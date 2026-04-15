
package textanalysis;


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
