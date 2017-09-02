/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixedhashmap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Sample program that tests the FixedHashMap using FixedHashMapNode objects
 *
 * @author dsli
 */
public class FixedHashMapConsole {

    public static void main(String[] args) {

    }

    public void start(Stage primaryStage) {
        VBox primaryPage = new VBox();
        HBox infoPane = new HBox();
        Label information = new Label("Please enter the size of the HashMap");
        TextField sizeBox = new TextField();
        infoPane.getChildren().addAll(information, sizeBox);
        Button enterButton = new Button("OK");
        enterButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e) {
            
        }
        });
        
        
    }
}
