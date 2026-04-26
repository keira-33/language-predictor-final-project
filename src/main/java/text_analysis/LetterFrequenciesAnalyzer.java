package text_analysis;

import java.util.Hashtable;

public class LetterFrequenciesAnalyzer extends TextAnalyzer {
    
    
    public LetterFrequenciesAnalyzer(){
        
       
    }
    
    @Override
    public double[] analyzeText(String textCollection){
        //CREATES A DISTRIBUTION VECTOR: EACH DATA POINT INDEX AND LETTER DATASET MATCH UP
        // EACH VECTOR VALUE IS THE PERCENTAGE THE LETTER IS USED IN THE TEXT 
        
        //FORMULA: VECTOR[N] = (COUNT OF LETTER OCCURRENCES) / (TOTAL COUNT OF LETTERS IN TEXT)
        char[] letterSet = LanguageRecordsContainer.getLetterDataset();
        //focus on chars only --> remove whitespace from text
        String textNoSpaces = removeWhiteSpace(textCollection);
        int letterCount = textNoSpaces.length();
        //create a hash table: key=character, value = count of occurences
        Hashtable<Character, Integer> hash = new Hashtable<>();
        for(int i=0; i<letterSet.length; i++){
            hash.put(letterSet[i],0);
        }
        //go through each character in textNoSpaces
        for(int i=0; i<textNoSpaces.length(); i++){
            if(hash.containsKey(textNoSpaces.charAt(i))){ // if the character is a valid key in the hashtable, increment the count
                hash.put(textNoSpaces.charAt(i),hash.get(textNoSpaces.charAt(i))+1);
            }else{
                letterCount --; // if character not in letter dataset --> decrease letter count size
            }
        }
        //turn the hash table into a vector using the formula --> return it
        double[] distVector = new double[letterSet.length];
        for(int i=0; i<distVector.length; i++){
            double result = hash.get(letterSet[i]);
            result = result/letterCount;
            distVector[i] = result;
        }
        
        //TESTING - DELETE LATER
        System.out.println(distVector);
        
       return distVector;
        
        
    }
    
}
