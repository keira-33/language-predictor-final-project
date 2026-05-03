package text_analysis.language_records;

public class PortugueseLangRecord extends LangRecord{
    //SINGLETON CLASS
    private static PortugueseLangRecord single_instance = null;
    
    private PortugueseLangRecord(String langCode, String fileName1, String fileName2, String langName){
        super(langCode, fileName1, fileName2, langName);
    }
    // SINGLETON METHOD:
    public static PortugueseLangRecord getInstance(String langCode,String fileName1, String fileName2, String langName){
        if (single_instance == null){
            single_instance = new PortugueseLangRecord(langCode,fileName1,fileName2, langName);
        }
        return single_instance; 
    }
}
