package text_analysis;

import java.util.Hashtable;

public class WordLengthAnalyzer extends TextAnalyzer {
    
    
    public WordLengthAnalyzer(){
        
    }
    @Override
    public double[] analyzeText(String textCollection){
        //CREATES A DISTRIBUTION VECTOR: WORD LENGTHS 1-14 [index = wordlength n]
        //Each value in vector is between 0 and 1 | sum of vector values is 1
        
        //FORMULA: vector[n] = (count of words length n)/(total word count)
        //split textCollection by spaces --> get a tokenized list
        String[] tokenizedCollection = textCollection.split("\\s+");
        int wordCount = tokenizedCollection.length;
        //create a hash table for each len of word in list -- increment counters
        Hashtable<Integer, Integer> hash = new Hashtable<>();
        for(int i=0; i<15; i++){
            hash.put(i,0);
        }
        //go through each item in the split list
        for(String word : tokenizedCollection){
            if(word.length() < 15){
                hash.put(word.length(),hash.get(word.length())+1);
            }
        }
        
        //turn the hash table into a vector using the formula --> return it
        double[] distVector = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        if(wordCount == 0){ //protection against really short texts --> prevent the division by 0 later on
           return distVector;
        }
        for(int i=0; i<distVector.length; i++){ // i is n - 1
            double result = (double) hash.get(i+1);
            result = result/wordCount;
            distVector[i] = result;
        }
        
        //TESTING - DELETE LATER
        //System.out.println(distVector);
        
       return distVector;
        
    }
}
