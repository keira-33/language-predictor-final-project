
package com.mycompany.kfrey_csc261_final.MVC;


public class MVC {
    public static void main(String[] args){
        Model m = new Model();
        
        Controller c = new Controller(m);
        
        View v1 = new View(m);
        View v2 = new View(m);
        View v3 = new View(m);
        View v4 = new View(m);
        View v5 = new View(m);
        View v6 = new View(m);
        View v7 = new View(m);

    }
}
