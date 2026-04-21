
package text_analysis;

import java.io.FileReader;

public abstract class TextAnalyzer {
    
         
    public TextAnalyzer(){
        
    }
    
    public abstract double[] analyzeText(String textCollection);
    
    public static String readFileIntoString(String fileName, String langCode){
        //partially followed geeksforgeeks filereader class page and file reader code from my csc260 project
        //issues with this 1. use a buff reader too? 2. string concatentation in while loop is making a new string every time (bad memory wise)
        try{
            FileReader fileReader = new FileReader("csc261-corpora/corpora/" + langCode + "/"+ fileName);
            String fileAsString = "";
            int character;
            while ((character = fileReader.read()) != -1) { 
                fileAsString += ((char)character);
            }
            fileReader.close();
            return fileAsString;
        }catch (Exception e) { // these are hardcoded values --> tested, so error catching for compiler only 
            e.printStackTrace();
            return "";
        }
    }
    public static String processText(String text){
        //NORMALIZES TEXT --> LOWERCASE ✔, REMOVE PUNCTUATION (KEEP WHITESPACE) ✔
        //remove punctuation code borrowed from: https://www.geeksforgeeks.org/dsa/removing-punctuations-given-string/
        text = text.replaceAll("\\p{Punct}","");
        //end of borrowed code
        text = text.toLowerCase();
        
        return text;
    }
    
    public String removeWhiteSpace(String textCollection){
        // REMOVES THE WHITESPACE FROM A GIVEN STRING OBJECT OF TEXT 
        //remove whitespace code borrowed from: https://www.w3schools.com/java/java_howto_remove_whitespace.asp
        String noSpacesCollection = textCollection.replaceAll("\\s+", ""); //replaceAll returns a new String object 
        //end of borrowed code
        return noSpacesCollection;
    }
    
}
