
package text_analysis.language_records;


public class EnglishLangRecord {
    private String textCollection;
    private String langCode;
    
    
    public EnglishLangRecord(String langCode){
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
