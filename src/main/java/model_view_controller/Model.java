
package model_view_controller;

import java.util.ArrayList;
import text_analysis.LanguageRecordsContainer;
import text_analysis.language_records.EnglishLangRecord;

public class Model {
    private String inputtedTxt;
    private ArrayList<ModelChangedEventHandler> observers ;
    private LanguageRecordsContainer recordsContainer;
    
    public Model(){
        //initialize all the languages + initial analysis
        recordsContainer = LanguageRecordsContainer.getInstance();
    }
    //Model needs observer list 
    public void changeTheData(String newText){
        inputtedTxt = newText;
        System.out.println("The text is now: " + inputtedTxt);
        //notifyObservers();
        
        //testing:
        //System.out.println(recordsContainer.getEnglishRecord().getTextCollection().substring(0, 20));
//        EnglishLangRecord tmpEng = recordsContainer.getEnglishRecord();
//        System.out.println(tmpEng.getTextCollection().substring(0, 20));
    }
    
    public void doSomething(String text){
        System.out.println("I received the new text!");
    }
    
//    public void changeTheData(String newValue){
//        theData = newValue;
//        System.out.println("The data is now: " + theData);
//        notifyObservers();
//    }
//   
//    private void notifyObservers(){
//        for(ModelChangedEventHandler observer : observers){
//            observer.handleModelChangeEvent();
//        }
//    }
//
//    public void attach(ModelChangedEventHandler  o){
//        observers.add(o);
//    }
}
