
package text_analysis;

import text_analysis.language_records.EnglishLangRecord;

public class LanguageRecordsContainer {
    //SINGLETON CLASS
    // consider a hash map with langCodes as keys {replace 17-22 w hashmap}
    private String[] langCodes = {"eng", "spa", "fre","deu"}; // eng| english; spa | spanish; fre| french; deu| german 
    private String[] textFiles = {"the-great-gatsby-1925.txt", "times-year-in-review-2019.txt", "garcía-gual-historia-mínima-de-la-mitología-2014.txt",
        "biblioteca-de-artica-2017.txt", "20-minutes-magazine-2013.txt", "dans-les-coulisses-des-jeux-vidéo-harry-potter-2019.txt", 
        "die-verwandlung-franz-kafka-1917.txt", "fenaco-stadt-land-monitor-2021-2023.txt"};
    
//    private String engTxt1 = "the-great-gatsby-1925.txt";
//    private String engTxt2 = "times-year-in-review-2019.txt";
//    private String spaTxt1 = "garcía-gual-historia-mínima-de-la-mitología-2014.txt";
//    private String spaTxt2 = "biblioteca-de-artica-2017.txt";
//    private String freTxt1 = "20-minutes-magazine-2013.txt";
//    private String freTxt2 = "dans-les-coulisses-des-jeux-vidéo-harry-potter-2019.txt";
//    private String deuTxt1 = "die-verwandlung-franz-kafka-1917.txt";
//    private String deuTxt2 = "fenaco-stadt-land-monitor-2021-2023.txt";
    
    private EnglishLangRecord engRecord;
    private EnglishLangRecord spaRecord;
    private EnglishLangRecord freRecord;
    private EnglishLangRecord deuRecord;
    
    private char[] letterDataset = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','á','é','í','ó','ú','ñ','ü','à','è','ù','ç','â','ê','î','ô','û','ë','ï','ä','ö','ß'};
    
    private static EnglishLangRecord[] recordsContainer;
    
    private static LanguageRecordsContainer single_instance = null;
    
    private LanguageRecordsContainer(){
        //maintain order of creation
        engRecord = new EnglishLangRecord("eng");
        spaRecord = new EnglishLangRecord("spa");
        freRecord = new EnglishLangRecord("fre");
        deuRecord = new EnglishLangRecord("deu");
        recordsContainer = new EnglishLangRecord[] {engRecord, spaRecord, freRecord, deuRecord};
    }
    //GETTERS
    public static LanguageRecordsContainer getInstance(){
        if (single_instance == null){
            single_instance = new LanguageRecordsContainer();
        }
        return single_instance; 
    }
    
    public char[] getLetterDataset(){
        return letterDataset;
    }
    
    public static void initializeFiles(){
        //load each of the files in and add their string information with initial text processing to their record/object in the list 
        String tempStr = "";
        for(int i = 0; i < recordsContainer.length; i++){
            tempStr += TextAnalyzer.readFileIntoString(recordsContainer[i].getLangCode()+"Txt1", recordsContainer[i].getLangCode());
            tempStr += TextAnalyzer.readFileIntoString(recordsContainer[i].getLangCode()+"Txt2", recordsContainer[i].getLangCode());
            
            recordsContainer[i].setTextCollection(TextAnalyzer.processText(tempStr));
        }
    }
    
    public static void setLanguageRecordTextCollections(){
        // Goal: goes through each language record in recordsContainer, intializes files then
        // uses record.setTextCollection(String text) to assign text file to 
        // the files list is in correct order of lang -- 2 per language
    }
     
}
