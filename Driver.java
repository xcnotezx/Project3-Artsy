package main.java.cs1302.p2;

import main.java.cs1302.effects.Artsy;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/**
 * This is the driver for this application.
 */
public class Driver extends Application {

	Stage window;
	BorderPane mainLayout;
	BorderPane topLayout;
	
	public static void main(String[] args) {
        launch(args);
    } // main
	
    @Override
    public void start(Stage stage) throws Exception {
    	window = stage;
    	window.setTitle("Artsy");
    	
    	//File menu
    	Menu fileMenu = new Menu("File");
    	
    	//Menu item
    	MenuItem open = new MenuItem("Open");
    	open.setOnAction(e -> System.out.println("OPEN")); //setOnAction OPEN
    	fileMenu.getItems().add(open);
    	fileMenu.getItems().add(new SeparatorMenuItem());
    	MenuItem saveResultAs = new MenuItem("Save Result As");
    	saveResultAs.setOnAction(e -> System.out.println("SAVE RESULT AS")); //setOnAction SAVE RESULTS AS
    	fileMenu.getItems().add(saveResultAs);
    	fileMenu.getItems().add(new SeparatorMenuItem());
    	MenuItem exit = new MenuItem("Exit");
    	exit.setOnAction(e -> window.close());
    	fileMenu.getItems().add(exit);
    	
    	//Main menu bar
    	MenuBar menuBar = new MenuBar();
    	menuBar.getMenus().addAll(fileMenu);
        
    	//Top buttons
    	HBox topMenu = new HBox();
	    topMenu.setPadding(new Insets(15, 12, 15, 12));
	    topMenu.setSpacing(10);
	    
	    Button checkers = new Button("Checkers");
	    checkers.setOnAction(e -> System.out.println("CHECKERS")); //setOnAction CHECKERS
    	Button horizontalStripes = new Button("Horizontal Stripes");
    	horizontalStripes.setOnAction(e -> System.out.println("HORIZONTAL STRIPES")); //setOnAction HORIZONTAL STRIPES
    	Button verticalStripes = new Button("Vertical Stripes");
    	verticalStripes.setOnAction(e -> System.out.println("VERTICAL STRIPES")); //setOnAction VERTICAL STRIPES
    	topMenu.getChildren().addAll(checkers, horizontalStripes, verticalStripes);
    	
    	//Bottom buttons
    	
    	
    	topLayout = new BorderPane();
    	topLayout.setTop(menuBar);
    	topLayout.setBottom(topMenu);
    	
    	mainLayout = new BorderPane();
    	mainLayout.setTop(topLayout);
    	
    	Scene scene = new Scene(mainLayout, 400, 300);
    	window.setScene(scene);
    	window.show();
    } // createAndShowGUI

} // Driver
