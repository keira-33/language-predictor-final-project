
package text_analysis.language_records;

import text_analysis.TextAnalyzer;

public class LangRecord {
    protected String textCollection;
    protected String langCode;
    protected String langName;
    private String fileName1;
    private String fileName2;
    //distribution vectors - only computed and stored once 
    private double[] bigramDistVector;
    private double[] letterFreqDistVector;
    private double[] trigramDistVector;
    private double[] wordLengthDistVector;
    
    private double cosineSimScore;
    
    
    public LangRecord(String langCode, String fileName1, String fileName2, String langName){
        this.langCode = langCode; 
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
        this.langName = langName;
        initializeFilesIntoTextCollection();
    }
    
    //getters
    public String getLangCode(){
        return langCode;
    }
    public String getLangName(){
        return langName;
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
    
    
    
   //getters
    public double[] getBigramVector(){
        return this.bigramDistVector;
    }
    public double[] getLetterFreqVector(){
        return this.letterFreqDistVector;
    }
    public double[] getTrigramVector(){
        return this.trigramDistVector;
    }
    public double[] getWordLengthVector(){
        return this.wordLengthDistVector;
    }
    public double getCosineSimScore(){
        return this.cosineSimScore;
    }

   //setters
    public void setBigramVector(double[] vector){
        this.bigramDistVector = vector;
    }
    public void setLetterFreqVector(double[] vector){
        this.letterFreqDistVector = vector;
    }
    public void setTrigramVector(double[] vector){
        this.trigramDistVector = vector;
    }
    public void setWordLengthVector(double[] vector){
        this.wordLengthDistVector = vector;
    }
    public void setCosineSimScore(double value){
        this.cosineSimScore = value;
    }
}
