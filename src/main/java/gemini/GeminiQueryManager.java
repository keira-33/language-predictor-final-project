
package gemini;

import com.google.genai.Client;
import com.google.genai.errors.ServerException;
import com.google.genai.types.GenerateContentResponse;
import java.util.prefs.Preferences;
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

            System.out.println(response.text());
            return response.text(); // TO DO: fix this return statement later 
        }catch(ServerException ex){
            // it failed...
            JOptionPane.showMessageDialog(null,
                    "Gemini API is Unavailable at this time",
                    "API Request Failed",
                    JOptionPane.ERROR_MESSAGE);
            return "Request Failed";
        }
  }
       
}
