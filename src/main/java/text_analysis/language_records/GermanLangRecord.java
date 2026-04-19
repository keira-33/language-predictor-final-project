
package text_analysis.language_records;


public class GermanLangRecord extends LangRecord{
    //SINGLETON CLASS
    private static GermanLangRecord single_instance = null;
    
    private GermanLangRecord(String langCode,String fileName1, String fileName2){
        super(langCode, fileName1, fileName2);
    }
    
    // SINGLETON METHOD:
    public static GermanLangRecord getInstance(String langCode,String fileName1, String fileName2){
        if (single_instance == null){
            single_instance = new GermanLangRecord(langCode, fileName1, fileName2);
        }
        return single_instance; 
    }
}
