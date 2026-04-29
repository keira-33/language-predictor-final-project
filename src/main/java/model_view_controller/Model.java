
package model_view_controller;

import java.util.ArrayList;
import text_analysis.LanguageRecordsContainer;
import text_analysis.language_records.EnglishLangRecord;
import gemini.GeminiQueryManager;
import text_analysis.BigramAnalyzer;
import text_analysis.ComprehensiveAnalyzer;
import text_analysis.LetterFrequenciesAnalyzer;
import text_analysis.TrigramAnalyzer;
import text_analysis.WordLengthAnalyzer;
import text_analysis.language_records.LangRecord;

public class Model {
    private String inputtedTxt;
    private ArrayList<ModelChangedEventHandler> observers ;
    private ArrayList<LangRecord> recordsContainer;
    private ArrayList<double[]> allVectors;
    private String guessedLang;
    
    //all inputted text's vectors 
    private double[] bigramVectorInput;
    private double[] letterFreqVectorInput;
    private double[] trigramVectorInput;
    private double[] wordLengthVectorInput;
    
    public Model(){
        observers = new ArrayList<>();
        allVectors = new ArrayList<>();
        //initialize all the languages + initial analysis
        recordsContainer = new ArrayList<>();
        recordsContainer = LanguageRecordsContainer.getInstance().getAllRecords();
    }
    
    public void changeTheData(String newText){
       inputtedTxt = newText;
       runAnalyzersOnInputtedTextAndSetVectors();
       ComprehensiveAnalyzer.getInstance().runAllAnalyzersOnLangRecords();
 
       //MUST DETERMINE GUESSED LANG 
       guessedLang = "Spanish";
       notifyObservers();
    }
    
    public void runAnalyzersOnInputtedTextAndSetVectors(){
        allVectors.clear();//wipe old vectors for new input
        //initialize all the analyzer objects
        BigramAnalyzer bigramObjInp = new BigramAnalyzer();
        TrigramAnalyzer trigramObjInp = new TrigramAnalyzer();
        LetterFrequenciesAnalyzer letterFreqObjInp = new LetterFrequenciesAnalyzer();
        WordLengthAnalyzer wordLenObjInp = new WordLengthAnalyzer();
        //run the analyze() methods and set values and add vectors to the list
        this.bigramVectorInput = bigramObjInp.analyzeText(this.inputtedTxt);
        allVectors.add(bigramVectorInput);
        this.letterFreqVectorInput = letterFreqObjInp.analyzeText(this.inputtedTxt);
        allVectors.add(letterFreqVectorInput);
        this.trigramVectorInput = trigramObjInp.analyzeText(this.inputtedTxt);
        allVectors.add(trigramVectorInput);
        this.wordLengthVectorInput = wordLenObjInp.analyzeText(this.inputtedTxt);
        allVectors.add(wordLengthVectorInput);
    }
    
    public void runCosineSimilarityOnAll(){
        
    }
    
    
    
    
    
    
    
    
    

    public void changeTheDataOLDMETHODFORTESTING_DELETE_LATER(String newText){
        inputtedTxt = newText;
        System.out.println("The text is now: " + inputtedTxt);
        //testing gemini stuff: //
        //System.out.println("Gemini spit this out:");
        //System.out.println(GeminiQueryManager.get().promptGemini("Given this text: Hola como estas? Bienvenidos a mi casa! ; What language do you think that text is written in and give two bullet points why you think this."));
        //HERE: BROADCAST ACTION CHANGELISTENER TYPE THING FOR VIEW TO GET 
        guessedLang = "Spanish";
        notifyObservers();
        
        
        //end of testing gemini stuff//
        
        //notifyObservers();
        
        //testing:
        //System.out.println(recordsContainer.getEnglishRecord().getTextCollection().substring(0, 20));
//        EnglishLangRecord tmpEng = recordsContainer.getEnglishRecord();
//        System.out.println(tmpEng.getTextCollection().substring(0, 20));
    }
    
    private void notifyObservers(){
        for(ModelChangedEventHandler observer : observers){
            observer.handleModelChangeEvent();
        }
    }

    public void attach(ModelChangedEventHandler  o){
        observers.add(o);
    }
    
    public String getThePrediction(){
        return guessedLang;
    }
}
