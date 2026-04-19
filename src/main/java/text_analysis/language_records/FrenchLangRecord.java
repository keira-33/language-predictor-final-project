
package text_analysis.language_records;


public class FrenchLangRecord extends LangRecord{
    //SINGLETON CLASS
    private static FrenchLangRecord single_instance = null;
    
    private FrenchLangRecord(String langCode, String fileName1, String fileName2){
        super(langCode, fileName1, fileName2);
    }
    
    // SINGLETON METHOD:
    public static FrenchLangRecord getInstance(String langCode,String fileName1, String fileName2){
        if (single_instance == null){
            single_instance = new FrenchLangRecord(langCode, fileName1, fileName2);
        }
        return single_instance; 
    }
}
