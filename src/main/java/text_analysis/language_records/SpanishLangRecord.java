
package text_analysis.language_records;


public class SpanishLangRecord extends LangRecord{
    //SINGLETON CLASS
    private static SpanishLangRecord single_instance = null;
    
    private SpanishLangRecord(String langCode,String fileName1, String fileName2, String langName){
        super(langCode, fileName1, fileName2, langName);
    }
    
    // SINGLETON METHOD:
    public static SpanishLangRecord getInstance(String langCode,String fileName1, String fileName2, String langName){
        if (single_instance == null){
            single_instance = new SpanishLangRecord(langCode,fileName1, fileName2, langName);
        }
        return single_instance; 
    }
}
