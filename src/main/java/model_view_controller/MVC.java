
package model_view_controller;

import text_analysis.ComprehensiveAnalyzer;


public class MVC {
    public static void main(String[] args){
        Model m = new Model();
        
        Controller c = new Controller(m);
        
        View v1 = new View(m, c);
        
        v1.setVisible(true);
        
        Thread th = new Thread(()->{
            ComprehensiveAnalyzer.getInstance().runAllAnalyzersOnLangRecords(); 
        });
        th.start();

    }
}


//
//public class MVC {
//    public static void main(String[] args){
//        Model m = new Model();
//        
//        Controller c = new Controller(m);
//        
//        View v1 = new View(m, c);
//        
//        v1.setVisible(true);
//
//    }
//}