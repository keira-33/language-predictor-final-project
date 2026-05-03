
package text_analysis.language_records;

public class TagalogLangRecord extends LangRecord{
    //SINGLETON CLASS
    private static TagalogLangRecord single_instance = null;
    
    private TagalogLangRecord(String langCode, String fileName1, String fileName2, String langName){
        super(langCode, fileName1, fileName2, langName);
    }
    // SINGLETON METHOD:
    public static TagalogLangRecord getInstance(String langCode,String fileName1, String fileName2, String langName){
        if (single_instance == null){
            single_instance = new TagalogLangRecord(langCode,fileName1,fileName2, langName);
        }
        return single_instance; 
    }
}
