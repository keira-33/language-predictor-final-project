
package textanalysis;

import java.io.FileReader;
import java.util.ArrayList;

public abstract class TextAnalyzer {
    
         
    public TextAnalyzer(){
        
    }
    
    public static void initializeFiles(){
        //load each of the files in but then I have to like add this stuff to a hashmap or collection of objects 
    }
    
    public static String readFileIntoString(String fileName, String langCode){
        //partially followed geeksforgeeks filereader class page and file reader code from my csc260 project
        //issues with this 1. use a buff reader too? 2. string concatentation in while loop is making a new string every time (bad memory wise)
        try{
            FileReader fileReader = new FileReader("csc261-corpora/corpora/" + langCode + fileName);
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
    public String processText(){
        //this will prepare text for analysis --> lowercase, remove punctuation 
    }
}
