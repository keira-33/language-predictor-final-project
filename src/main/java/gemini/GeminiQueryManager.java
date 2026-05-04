
package gemini;

import com.google.genai.Client;
import com.google.genai.errors.ServerException;
import com.google.genai.types.GenerateContentResponse;
import java.util.prefs.Preferences;
import com.google.genai.types.Content;
import com.google.genai.types.Part;
import javax.swing.JOptionPane;

public class GeminiQueryManager {
    //SINGLETON CLASS 
    private Client client;
    private static GeminiQueryManager inst;
    private String myKey;
    
    
    private GeminiQueryManager(){
        myKey = Preferences.userRoot().get("GeminiKey", null);
        while(myKey == null){
            String s = JOptionPane.showInputDialog(null, "Please enter your Gemini API Key.","Please enter your API key here",JOptionPane.QUESTION_MESSAGE);
            Preferences.userRoot().put("GeminiKey", s);        
            myKey = s;
        }
        
        client = Client.builder().apiKey(myKey).build();        
    }
    //SINGLETON GETTER METHOD
    public static GeminiQueryManager get(){
        if(inst == null)
            inst = new GeminiQueryManager();
        return inst;
    }
    
    public String promptGemini(String promptTxt){
        try{
           GenerateContentResponse response =
            client.models.generateContent(
                "gemini-3-flash-preview",
                promptTxt, // " Ask me a question?"  
                null);

            //System.out.println(response.text());
            return response.text(); 
        }catch(ServerException ex){
            // it failed...
            JOptionPane.showMessageDialog(null,
                    "Gemini API is Unavailable at this time",
                    "API Request Failed",
                    JOptionPane.ERROR_MESSAGE);
            return "Request Failed";
        }
    }
    
    public String promptGeminiWithImage(byte[] imgAsBytes){
       //followed these tutorials to get multimodal content as inputs to gemini api:
       //https://medium.com/@kandaanusha/google-gen-ai-integration-java-af984aac126c
       //https://ai.google.dev/gemini-api/docs/file-input-methods#python_6
       try{
           //first construct multimodal content
           Content content = Content.fromParts(
                Part.fromText("The given image should have text on it. Give the text found in the image. If no text found, your response should be '-'."),
                Part.fromBytes(imgAsBytes, "image/png"));
           
               GenerateContentResponse response =
                    client.models.generateContent(
                        "gemini-3-flash-preview",
                        content, // input
                        null);
               //System.out.println(response.text());
               return response.text();
           
        }catch(ServerException ex){
            // it failed...
            JOptionPane.showMessageDialog(null,
                    "Gemini API is Unavailable at this time",
                    "API Request w/ Image Input Failed",
                    JOptionPane.ERROR_MESSAGE);
            return "Request Failed";
        }
    }
       
}
