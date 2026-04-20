
package model_view_controller;

import java.util.ArrayList;

public class Model {
    private String inputtedTxt;
    private ArrayList<ModelChangedEventHandler> observers ;
    
    public Model(){
        
    }
    //Model needs observer list 
    public void changeTheData(String newText){
        inputtedTxt = newText;
        System.out.println("The text is now: " + inputtedTxt);
        //notifyObservers();
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
