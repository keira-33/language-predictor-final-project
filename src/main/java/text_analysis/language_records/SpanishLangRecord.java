
package text_analysis.language_records;


public class SpanishLangRecord {
    private String textCollection;
    private String langCode;
    
    
    public SpanishLangRecord(String langCode){
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
