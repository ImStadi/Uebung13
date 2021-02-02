/**
 * @author Stadler Andre
 * @version 21.1.2021
 */
package main;

import javafx.application.Application;
import javafx.stage.Stage;
import viewC.Controller;

public class Main extends Application
{

    @Override
    public void start(Stage stage) throws Exception{
        Controller.show(stage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
