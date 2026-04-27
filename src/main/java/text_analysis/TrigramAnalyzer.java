package text_analysis;

import java.util.Hashtable;

public class TrigramAnalyzer extends TextAnalyzer {
    
    
    public TrigramAnalyzer(){
        
    }
    
    @Override
    public double[] analyzeText(String textCollection){
        //COUNTS ALL THE THREE CHAR LETTER PAIRS IN TEXT COLLECTION'S WORDS
        // ENDING VECTOR TELLS YOU PERCENTAGE OF OCCURENCES OF EACH TRIGRAM
        
        //FORMULA: VECTOR[X] = (COUNT OF SPECIFIC TRIGRAM OCCURRENCES) / (TOTAL COUNT OF TRIGRAMS IN TEXT)
        //get letterset and initialize a total bigram count int var
        char[] letterSet = LanguageRecordsContainer.getLetterDataset();
        int totalTrigramCt = 0;
        
        //Loop through letterSet and create trigram sets to initialize hashmap with
        Hashtable<String, Integer> hash = new Hashtable<>(); // key: char pair as string | val: count of trigram occurences
        for(int i=0; i<letterSet.length; i++){ // first letter in bigram
            for(int j=0; j<letterSet.length; j++){ // second letter in bigram
                for(int k=0; k<letterSet.length; k++){
                    String trigram = Character.toString(letterSet[i]) + Character.toString(letterSet[j])+ Character.toString(letterSet[k]);
                    hash.put(trigram,0);// initialize each count as 0
                }
            }
        }
        //go through each character in textCollection like a sliding window
        // if the character [i] or next character [i+1] or next character  is not whitespace, then increment count in hashtable
        for(int i=0; i<(textCollection.length()-2); i++){ //text collection -2 to protect from end index out range
            String tmpKey = Character.toString(letterSet[i]) + Character.toString(letterSet[i+1])+ Character.toString(letterSet[i+2]);
            //checks if trigram is in hashmap (is valid) and no character is a whitespace --> increment both hashmap and total counts 
            if(hash.containsKey(tmpKey) && !Character.isWhitespace(letterSet[i]) && !Character.isWhitespace(letterSet[i+1])&& !Character.isWhitespace(letterSet[i+2])){
                hash.put(tmpKey,hash.get(tmpKey)+1);
                totalTrigramCt ++;
            }    
        }
        
        //go through each key in the hash table and create the final vector using formula 
        // to find index of bigram in arraylist-- i*n + j (page plus offset basically)
        //n = size of letterSet 
        // i = first bigram char index in letter set (think of first letter as the page --> i*n is page space address)
        // j = second bigram char index in letter set (think of this as the offset within the first letter page)
        double[] distVector = new double[(letterSet.length * letterSet.length * letterSet.length)];
        for(int i=0; i<letterSet.length; i++){ // first letter in trigram
            for(int j=0; j<letterSet.length; j++){ // second letter in trigram
                for(int k=0; k<letterSet.length; k++){ // third letter in trigram
                    String trigram = Character.toString(letterSet[i]) + Character.toString(letterSet[j])+ Character.toString(letterSet[k]);
                    distVector[(i*letterSet.length)+j]= (hash.get(trigram))/totalTrigramCt;// initialize each count as 0
                }
            }
        }
        
        return distVector;      
    }
}
