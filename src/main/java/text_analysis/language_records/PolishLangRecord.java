package text_analysis.language_records;

public class PolishLangRecord extends LangRecord{
    //SINGLETON CLASS
    private static PolishLangRecord single_instance = null;
    
    private PolishLangRecord(String langCode, String fileName1, String fileName2, String langName){
        super(langCode, fileName1, fileName2, langName);
    }
    // SINGLETON METHOD:
    public static PolishLangRecord getInstance(String langCode,String fileName1, String fileName2, String langName){
        if (single_instance == null){
            single_instance = new PolishLangRecord(langCode,fileName1,fileName2, langName);
        }
        return single_instance; 
    }
}
