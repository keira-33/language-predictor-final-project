
package mvc;

public class Model {
    private String inputtedTxt;
    
    public Model(){
        
    }
    //Model needs observer list 
    public void changeTheData(String newValue){
        inputtedTxt = newValue;
        System.out.println("The data is now: " + inputtedTxt);
        //notifyObservers();
    }
}
