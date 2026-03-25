
package textanalysis;

public class LanguageRecordsContainer {
    //** TO DO: make this singleton
    private String[] langCodes = {"eng", "spa", "fre","deu"}; // eng| english; spa | spanish; fre| french; deu| german 
    private String engTxt1 = "the-great-gatsby-1925.txt";
    private String engTxt2 = "times-year-in-review-2019.txt";
    private String spaTxt1 = "garcía-gual-historia-mínima-de-la-mitología-2014.txt";
    private String spaTxt2 = "biblioteca-de-artica-2017.txt";
    private String freTxt1 = "20-minutes-magazine-2013.txt";
    private String freTxt2 = "dans-les-coulisses-des-jeux-vidéo-harry-potter-2019.txt";
    private String deuTxt1 = "die-verwandlung-franz-kafka-1917.txt";
    private String deuTxt2 = "fenaco-stadt-land-monitor-2021-2023.txt";
    
    private LanguageRecord engRecord;
    private LanguageRecord spaRecord;
    private LanguageRecord freRecord;
    private LanguageRecord deuRecord;
    
    private static LanguageRecord[] recordsContainer;
    
    public LanguageRecordsContainer(){
        engRecord = new LanguageRecord("eng");
        spaRecord = new LanguageRecord("spa");
        freRecord = new LanguageRecord("fre");
        deuRecord = new LanguageRecord("deu");
        recordsContainer = new LanguageRecord[] {engRecord, spaRecord, freRecord, deuRecord};
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
}
