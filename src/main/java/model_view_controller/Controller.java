package model_view_controller;

/**
 *
 * @author kfrey
 */
public class Controller {
    private Model model;
    private String inputtedTxt;
    //private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Controller.class.getName());
    
//    public Controller() {
//    }

    public Controller(Model m){
        this.model = m;
    }
    
    public void changeTheData(String newText){
        inputtedTxt = newText;
        System.out.println("The text is now: " + inputtedTxt);
        model.doSomething(inputtedTxt);
        //notifyObservers();
    }
}
