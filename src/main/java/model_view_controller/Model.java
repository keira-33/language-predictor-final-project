
package model_view_controller;

import java.util.ArrayList;
import text_analysis.LanguageRecordsContainer;
import text_analysis.language_records.EnglishLangRecord;
import gemini.GeminiQueryManager;
import text_analysis.BigramAnalyzer;
import text_analysis.ComprehensiveAnalyzer;
import text_analysis.CosineSimilarityAnalyzer;
import text_analysis.LetterFrequenciesAnalyzer;
import text_analysis.TrigramAnalyzer;
import text_analysis.WordLengthAnalyzer;
import text_analysis.language_records.LangRecord;

public class Model {
    private String inputtedTxt;
    private ArrayList<ModelChangedEventHandler> observers ;
    private ArrayList<LangRecord> recordsContainer;
    private ArrayList<double[]> allInputVectors;
    private String guessedLang;
    private String geminiResponse;
    
    //all inputted text's vectors 
    private double[] bigramVectorInput;
    private double[] letterFreqVectorInput;
    private double[] trigramVectorInput;
    private double[] wordLengthVectorInput;
    
    public Model(){
        observers = new ArrayList<>();
        allInputVectors = new ArrayList<>();
        //initialize all the languages + initial analysis
        recordsContainer = new ArrayList<>();
        recordsContainer = LanguageRecordsContainer.getInstance().getAllRecords();
        //run all the analysis --> model only gets instantiated x1 so analyzers only get run x1 for base languages 
        ComprehensiveAnalyzer.getInstance().runAllAnalyzersOnLangRecords(); 
    }
    
    public void changeTheData(String newText){
       inputtedTxt = newText;
       runAnalyzersOnInputtedTextAndSetVectors();
       runCosineSimilarityOnAll();
       //MUST DETERMINE GUESSED LANG before calling notify
       guessedLang = runCosineSimilarityOnAll();
       //testing gemini stuff: //
       geminiResponse = GeminiQueryManager.get().promptGemini("Given this text:"+ inputtedTxt +"; What language do you think that text is written in and give two bullet points why you think this. "
               + "Only respond in this format (separate all points with a pipe|): predicted language | reason one | reason 2");
       notifyObservers();
    }
    
    public void runAnalyzersOnInputtedTextAndSetVectors(){
        allInputVectors.clear();//wipe old vectors for new input
        //initialize all the analyzer objects
        BigramAnalyzer bigramObjInp = new BigramAnalyzer();
        TrigramAnalyzer trigramObjInp = new TrigramAnalyzer();
        LetterFrequenciesAnalyzer letterFreqObjInp = new LetterFrequenciesAnalyzer();
        WordLengthAnalyzer wordLenObjInp = new WordLengthAnalyzer();
        //run the analyze() methods and set values and add vectors to the list
        this.bigramVectorInput = bigramObjInp.analyzeText(this.inputtedTxt);
        allInputVectors.add(bigramVectorInput);
        this.letterFreqVectorInput = letterFreqObjInp.analyzeText(this.inputtedTxt);
        allInputVectors.add(letterFreqVectorInput);
        this.trigramVectorInput = trigramObjInp.analyzeText(this.inputtedTxt);
        allInputVectors.add(trigramVectorInput);
        this.wordLengthVectorInput = wordLenObjInp.analyzeText(this.inputtedTxt);
        allInputVectors.add(wordLengthVectorInput);
    }
    
    public String runCosineSimilarityOnAll(){
        //vectors closer to 1 are pointing in the same direction
        //sum up all individual analyzer vectors --> closest to 1 is the guess
        for(LangRecord record : recordsContainer){
            double cosineScoreSum = 0;
            cosineScoreSum = addWithCheck(cosineScoreSum, CosineSimilarityAnalyzer.computeCosineSimilarityOfTwoVectors(bigramVectorInput,record.getBigramVector()));
            
            cosineScoreSum = addWithCheck(cosineScoreSum, CosineSimilarityAnalyzer.computeCosineSimilarityOfTwoVectors(letterFreqVectorInput,record.getLetterFreqVector()));
            
            cosineScoreSum = addWithCheck(cosineScoreSum, CosineSimilarityAnalyzer.computeCosineSimilarityOfTwoVectors(trigramVectorInput,record.getTrigramVector()));
            
            cosineScoreSum = addWithCheck(cosineScoreSum, CosineSimilarityAnalyzer.computeCosineSimilarityOfTwoVectors(wordLengthVectorInput,record.getWordLengthVector()));
            
            record.setCosineSimScore(cosineScoreSum);
            System.out.println(record.getLangName()+": "+ cosineScoreSum);
        }
        //get the record with the highest sum 
        LangRecord recordGuess = returnLargestCosineSimScoreRecord();
        System.out.println("The guess is " + recordGuess);
        
        return recordGuess.getLangName();
        
    }
    
    public LangRecord returnLargestCosineSimScoreRecord(){
        LangRecord currentMax = null;
        for(LangRecord record : recordsContainer){
            if (currentMax == null){
                currentMax = record;
            }
            else{
                if(record.getCosineSimScore()>currentMax.getCosineSimScore() && !Double.isNaN(record.getCosineSimScore())){//take the greater one to be the new currMax (make sure not a NaN value)
                    currentMax = record;
                }
            }
        }
        
        return currentMax;
    }
    
    
    public double addWithCheck(double runningSum, double addend){
        //TO BE USED WITH RUNCOSINESIMILARITYONALL() TO PROTECT AGAINST NANS
        if(!Double.isNaN(addend)){
            runningSum += addend;
        }
        return runningSum;
    }
    
    
    private void notifyObservers(){
        for(ModelChangedEventHandler observer : observers){
            observer.handleModelChangeEvent();
        }
    }

    public void attach(ModelChangedEventHandler  o){
        observers.add(o);
    }
    
    //getters:
    public String getThePrediction(){
        return guessedLang;
    }
    public String getGeminiResponse(){
        return geminiResponse;
    }
}
