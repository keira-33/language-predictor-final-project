
package text_analysis;

import java.io.BufferedReader;
import java.io.FileReader;

public abstract class TextAnalyzer {
    
         
    public TextAnalyzer(){
        
    }
    
    public abstract double[] analyzeText(String textCollection);
    
    public static String readAndProcessFileIntoString(String fileName, String langCode){
        //READS TXT FILE LINE BY LINE AND NORMALIZES TEXT --> LOWERCASE ✔, REMOVE PUNCTUATION (KEEP WHITESPACE) ✔
        // RETURNS FILE AS A PROCESSED STRING 
        try{
            FileReader fileReader = new FileReader("csc261-corpora/corpora/" + langCode + "/"+ fileName);
            String fileAsString = "";
            BufferedReader buffReader = new BufferedReader(fileReader);
            String line;
            while ((line = buffReader.readLine()) != null) { 
                //remove punctuation code borrowed from: https://www.geeksforgeeks.org/dsa/removing-punctuations-given-string/
                line = line.replaceAll("\\p{Punct}","");
                 //end of borrowed code
                line = line.toLowerCase();
                fileAsString += line;
            }
            fileReader.close();
            buffReader.close();
            return fileAsString;
        }catch (Exception e) { // these are hardcoded values --> tested, so error catching for compiler only 
            e.printStackTrace();
            return "";
        }
    }
//    public static String processText(String text){
//        //NORMALIZES TEXT --> LOWERCASE ✔, REMOVE PUNCTUATION (KEEP WHITESPACE) ✔
//        //remove punctuation code borrowed from: https://www.geeksforgeeks.org/dsa/removing-punctuations-given-string/
//        text = text.replaceAll("\\p{Punct}","");
//        //end of borrowed code
//        text = text.toLowerCase();
//        
//        return text;
//    }
    
    public String removeWhiteSpace(String textCollection){
        // REMOVES THE WHITESPACE FROM A GIVEN STRING OBJECT OF TEXT 
        //remove whitespace code borrowed from: https://www.w3schools.com/java/java_howto_remove_whitespace.asp
        String noSpacesCollection = textCollection.replaceAll("\\s+", ""); //replaceAll returns a new String object 
        //end of borrowed code
        return noSpacesCollection;
    }
    
}
