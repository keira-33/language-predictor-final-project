package text_analysis;

import java.util.Hashtable;

public class BigramAnalyzer extends TextAnalyzer {
    
    public BigramAnalyzer(){
        
    }
    @Override
    public double[] analyzeText(String textCollection){
        //COUNTS ALL THE TWO CHAR LETTER PAIRS IN TEXT COLLECTION'S WORDS
        // ENDING VECTOR TELLS YOU PERCENTAGE OF OCCURENCES OF EACH BIGRAM
        
        //FORMULA: VECTOR[X] = (COUNT OF SPECIFIC BIGRAM OCCURRENCES) / (TOTAL COUNT OF BIGRAMS IN TEXT)
        //get letterset and initialize a total bigram count int var
        char[] letterSet = LanguageRecordsContainer.getLetterDataset();
        int totalBigramCt = 0;
        
        //Loop through letterSet and create bigram pairs to initialize hashmap with
        Hashtable<String, Integer> hash = new Hashtable<>(); // key: char pair as string | val: count of bigram
        for(int i=0; i<letterSet.length; i++){ // first letter in bigram
            for(int j=0; j<letterSet.length; j++){ // second letter in bigram
                String bigram = Character.toString(letterSet[i]) + Character.toString(letterSet[j]);
                hash.put(bigram,0);// initialize each count as 0
            }
        }
        //go through each character in textCollection like a sliding window
        // if the character [i] or next character [i+1] is not whitespace, then increment count in hashtable
        for(int i=0; i<(textCollection.length()-1); i++){ //text collection -1 to protect from end index out range
            String tmpKey = Character.toString(letterSet[i]) + Character.toString(letterSet[i+1]);
            //checks if bigram is in hashmap (is valid) and neither character is a whitespace --> increment both hashmap and total counts 
            if(hash.containsKey(tmpKey) && !Character.isWhitespace(letterSet[i]) && !Character.isWhitespace(letterSet[i+1])){
                hash.put(tmpKey,hash.get(tmpKey)+1);
                totalBigramCt ++;
            }    
        }
        
        //go through each key in the hash table and create the final vector using formula 
        // to find index of bigram in arraylist-- i*n + j (page plus offset basically)
        //n = size of letterSet 
        // i = first bigram char index in letter set (think of first letter as the page --> i*n is page space address)
        // j = second bigram char index in letter set (think of this as the offset within the first letter page)
        double[] distVector = new double[(letterSet.length * letterSet.length)];
        for(int i=0; i<letterSet.length; i++){ // first letter in bigram
            for(int j=0; j<letterSet.length; j++){ // second letter in bigram
                String bigram = Character.toString(letterSet[i]) + Character.toString(letterSet[j]);
                distVector[(i*letterSet.length)+j]= (hash.get(bigram))/totalBigramCt;// initialize each count as 0
            }
        }
        
        return distVector;      
    }
}
