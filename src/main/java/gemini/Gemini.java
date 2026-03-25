
package gemini;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class Gemini {
    
    public String promptGemini(String promptTxt){
        String myKey = "PUT KEY HERE";

        Client client = Client.builder().apiKey(myKey).build();

        GenerateContentResponse response =
            client.models.generateContent(
                "gemini-3-flash-preview",
                promptTxt, // " Ask me a question?" 
                null);

        System.out.println(response.text());
        return promptTxt; // TO DO: fix this return statement later
  }
    
}
