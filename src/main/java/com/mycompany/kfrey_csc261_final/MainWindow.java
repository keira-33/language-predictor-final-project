/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kfrey_csc261_final;

import java.io.FileReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author kfrey
 */
public class MainWindow {
    //chat gpt api --> following learn ai/ml channel tutorial on youtube
    private static final String API_KEY = "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";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    
    public MainWindow(){
        
    }
    
    public static void callingAPI(){
        try{
            String prompt = "What is the capital of France?";
            String payload = "{\n" +
                    "  \"model\": \"gpt-3.5-turbo\",\n" +
                    "  \"messages\": [\n" +
                    "    {\"role\": \"user\", \"content\": \"" + prompt + "\"}\n" +
                    "  ]\n" +
                    "}";
            String response = sendPostRequest(API_URL, payload);
            System.out.println("Response :" + response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    private static String sendPostRequest(String apiUrl, String payload)throws Exception{
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        
        connection.setRequestProperty("Authorization", "Bearer "+API_KEY);
        connection.setRequestProperty("Content-Type","application/json");
        
        try(OutputStream os = connection.getOutputStream()){
            os.write(payload.getBytes());
            os.flush();
        }
        
        StringBuilder response = new StringBuilder();
        try(Scanner scanner = new Scanner(connection.getInputStream())){
            while (scanner.hasNext()){
                response.append(scanner.nextLine());
            }
        }
        return response.toString();
    }
    
    public static String readFileIntoString(String file){
        //partially followed geeksforgeeks filereader class page and file reader code from my csc260 project
        //issues with this 1. use a buff reader too? 2. string concatentation in while loop is making a new string every time (bad memory wise)
        try{
            FileReader fileReader = new FileReader(file);
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
    
    
    
    public static void main(String[] args) {
        callingAPI();
        //System.out.println(readFileIntoString("csc261-corpora/corpora/english/the-great-gatsby-1925.txt"));
    }
}
