
package text_analysis.language_records;

import text_analysis.TextAnalyzer;

public class LangRecord {
    protected String textCollection;
    protected String langCode;
    private String fileName1;
    private String fileName2;
    
    public LangRecord(String langCode, String fileName1, String fileName2){
        this.langCode = langCode; 
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
        initializeFilesIntoTextCollection();
    }
    
    //getters
    public String getLangCode(){
        return langCode;
    }
    public String getTextCollection(){
        return textCollection;
    }
    
     public void initializeFilesIntoTextCollection(){
        //LOADS EACH OF THE TWO ASSIGNED FILES IN AND PROCESSES THE RAW TEXT 
        //USING TEXTANALYZER CLASS METHODS
        //ASSIGNS NORMALIZED/CLEANED TEXT TO TEXTCOLLECTION FIELD 
        String tempStr = "";
        //read in both files assigned to the language --> assign to temp string
        tempStr += TextAnalyzer.readAndProcessFileIntoString(this.fileName1, this.langCode);
        tempStr += TextAnalyzer.readAndProcessFileIntoString(this.fileName2, this.langCode);
        //normalize & set tempStr to text collection
        this.textCollection = tempStr;
        
        
        //TESTING -- REMOVE FOR FINAL:
        System.out.println(langCode + "I did it!");
        System.out.println(textCollection.substring(0, 20));
        // TESTING TESTING TESTING 
    }
}
