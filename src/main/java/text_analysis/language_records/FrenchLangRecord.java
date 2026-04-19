
package text_analysis.language_records;


public class FrenchLangRecord {
    private String textCollection;
    private String langCode;
    
    
    public FrenchLangRecord(String langCode){
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
