package main.java.cs1302.p2;

import main.java.cs1302.effects.Artsy;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * This is the driver for this application.
 */
public class Driver extends Application {

    @Override
    public void start(Stage stage) {
    	stage.setTitle("Artsy!");
    	BorderPane rootMenu = new BorderPane();
    	Scene scene = new Scene(rootMenu, 300, 250, Color.WHITE);
        
        //MENU File|Save Result As|Exit
    	MenuBar menuBar = new MenuBar();
    	menuBar.prefWidthProperty().bind(stage.widthProperty());
    	rootMenu.setTop(menuBar);
        Menu fileMenu = new Menu("File");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save Result As");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit() );

        fileMenu.getItems().addAll(openMenuItem,new SeparatorMenuItem(),
        		saveMenuItem,new SeparatorMenuItem(),
        		exitMenuItem
        		
        );
        menuBar.getMenus().addAll(fileMenu);
        
    	stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        
    } // createAndShowGUI

    public static void main(String[] args) {
        launch(args);
    } // main

} // Driver
