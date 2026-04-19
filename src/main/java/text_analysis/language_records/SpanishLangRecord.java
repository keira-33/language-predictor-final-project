
package text_analysis.language_records;


public class SpanishLangRecord extends LangRecord{
    //SINGLETON CLASS
    private static SpanishLangRecord single_instance = null;
    
    private SpanishLangRecord(String langCode,String fileName1, String fileName2){
        super(langCode, fileName1, fileName2);
    }
    
    // SINGLETON METHOD:
    public static SpanishLangRecord getInstance(String langCode,String fileName1, String fileName2){
        if (single_instance == null){
            single_instance = new SpanishLangRecord(langCode,fileName1, fileName2);
        }
        return single_instance; 
    }
}
