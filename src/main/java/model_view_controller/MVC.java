
package model_view_controller;


public class MVC {
    public static void main(String[] args){
        Model m = new Model();
        
        Controller c = new Controller(m);
        
        View v1 = new View(m, c);
        
        v1.setVisible(true);

    }
}
