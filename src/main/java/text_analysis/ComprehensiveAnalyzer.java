
package text_analysis;

import java.util.ArrayList;
import text_analysis.language_records.LangRecord;

public class ComprehensiveAnalyzer {
    //does all of the analyzers
    //SINGLETON CLASS
    private static ComprehensiveAnalyzer inst=null;
    private static ArrayList<LangRecord> allRecs;
    
    private ComprehensiveAnalyzer(){
        allRecs = new ArrayList<>();
        allRecs = LanguageRecordsContainer.getInstance().getAllRecords();
    }
    // SINGLETON METHOD:
    public static ComprehensiveAnalyzer getInstance(){
        if (inst == null){
            inst = new ComprehensiveAnalyzer();
        }
        return inst; 
    }
    
    //CALL TO RUN ALL ANALYZERS:
    public void runAllAnalyzersOnLangRecords(){
        runBigramAnalyzerOnAll();
        runTrigramAnalyzerOnAll();
        runLetterFreqAnalyzerOnAll();
        runWordLengthAnalyzerOnAll();
    }
    
    //INDIVIDUAL RUN METHODS 
    public void runBigramAnalyzerOnAll(){
        //go over each record and run the analyzer on the record and set using langRecord setter function
        BigramAnalyzer bigramObj = new BigramAnalyzer();
        for(LangRecord record : allRecs){
            record.setBigramVector(bigramObj.analyzeText(record.getTextCollection()));
        }
    }
    
    public void runTrigramAnalyzerOnAll(){
        //go over each record and run the analyzer on the record and set using langRecord setter function
        TrigramAnalyzer trigramObj = new TrigramAnalyzer();
        for(LangRecord record : allRecs){
            record.setTrigramVector(trigramObj.analyzeText(record.getTextCollection()));
        }
    }
    
    public void runLetterFreqAnalyzerOnAll(){
        //go over each record and run the analyzer on the record and set using langRecord setter function
        LetterFrequenciesAnalyzer letterFreqObj = new LetterFrequenciesAnalyzer();
        for(LangRecord record : allRecs){
            record.setLetterFreqVector(letterFreqObj.analyzeText(record.getTextCollection()));
        }
    }
    
    public void runWordLengthAnalyzerOnAll(){
        //go over each record and run the analyzer on the record and set using langRecord setter function
        WordLengthAnalyzer wordLenObj = new WordLengthAnalyzer();
        for(LangRecord record : allRecs){
            record.setWordLengthVector(wordLenObj.analyzeText(record.getTextCollection()));
        }
    }
    
    
}
