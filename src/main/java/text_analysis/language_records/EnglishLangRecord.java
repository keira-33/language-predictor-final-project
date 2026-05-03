
package text_analysis.language_records;


public class EnglishLangRecord extends LangRecord{
    //SINGLETON CLASS
    private static EnglishLangRecord single_instance = null;
    
    private EnglishLangRecord(String langCode, String fileName1, String fileName2, String langName){
        super(langCode, fileName1, fileName2, langName);
    }
    // SINGLETON METHOD:
    public static EnglishLangRecord getInstance(String langCode,String fileName1, String fileName2, String langName){
        if (single_instance == null){
            single_instance = new EnglishLangRecord(langCode,fileName1,fileName2, langName);
        }
        return single_instance; 
    }
}
