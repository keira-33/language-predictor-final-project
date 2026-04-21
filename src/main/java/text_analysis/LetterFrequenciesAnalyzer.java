package text_analysis;

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
        
    }
    
}

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
        for(int i=0; i<distVector.length; i++){ // i is n - 1
            double result = hash.get(i+1);
            result = result/wordCount;
            distVector[i] = result;
        }
        
        //TESTING - DELETE LATER
        System.out.println(distVector);
        
       return distVector;
        
    }
