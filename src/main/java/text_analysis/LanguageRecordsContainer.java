
package text_analysis;

import java.util.ArrayList;
import text_analysis.language_records.EnglishLangRecord;
import text_analysis.language_records.FrenchLangRecord;
import text_analysis.language_records.GermanLangRecord;
import text_analysis.language_records.LangRecord;
import text_analysis.language_records.SpanishLangRecord;

public class LanguageRecordsContainer {
    //SINGLETON CLASS
    private String[] langCodes = {"eng", "spa", "fre","deu"}; // eng| english; spa | spanish; fre| french; deu| german 
    private String[] textFiles = {"the-great-gatsby-1925.txt", "times-year-in-review-2019.txt", "garcía-gual-historia-mínima-de-la-mitología-2014.txt",
        "biblioteca-de-artica-2017.txt", "20-minutes-magazine-2013.txt", "dans-les-coulisses-des-jeux-vidéo-harry-potter-2019.txt", 
        "die-verwandlung-franz-kafka-1917.txt", "fenaco-stadt-land-monitor-2021-2023.txt"};
    //eng:0,1 | spa: 2,3 | fre: 4,5 | deu: 6,7 
    
    private static EnglishLangRecord engRecord;
    private static SpanishLangRecord spaRecord;
    private static FrenchLangRecord freRecord;
    private static GermanLangRecord deuRecord;
    
    private static ArrayList<LangRecord> allRecords;
    
    private static char[] letterDataset = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','á','é','í','ó','ú','ñ','ü','à','è','ù','ç','â','ê','î','ô','û','ë','ï','ä','ö','ß'};
    
    private static LanguageRecordsContainer single_instance = null;
    
    private LanguageRecordsContainer(){
        //maintain order of creation -- all objects are singletons
        engRecord = EnglishLangRecord.getInstance("eng", textFiles[0], textFiles[1], "English");
        spaRecord = SpanishLangRecord.getInstance("spa", textFiles[2], textFiles[3], "Spanish");
        freRecord = FrenchLangRecord.getInstance("fre", textFiles[4], textFiles[5], "French");
        deuRecord = GermanLangRecord.getInstance("deu", textFiles[6], textFiles[7], "German");
        //add all the records to the list
        allRecords = new ArrayList<>();
        allRecords.add(engRecord);
        allRecords.add(spaRecord);
        allRecords.add(freRecord);
        allRecords.add(deuRecord);
        
    }

    // SINGLETON METHOD:
    public static LanguageRecordsContainer getInstance(){
        if (single_instance == null){
            single_instance = new LanguageRecordsContainer();
        }
        return single_instance; 
    }
    //GETTERS
    public static char[] getLetterDataset(){
        return letterDataset;
    }
    public EnglishLangRecord getEnglishRecord(){
        return engRecord;
    }
    public SpanishLangRecord getSpanishRecord(){
        return spaRecord;
    }
    public FrenchLangRecord getFrenchRecord(){
        return freRecord;
    }
    public GermanLangRecord getGermanRecord(){
        return deuRecord;
    }
    public ArrayList<LangRecord> getAllRecords(){
        return allRecords;
    }
    
    
}
