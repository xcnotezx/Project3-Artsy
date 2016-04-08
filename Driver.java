package main.java.cs1302.p2;

import main.java.cs1302.effects.Artsy;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/**
 * This is the driver for this application.
 */
public class Driver extends Application {

	Stage window;
	BorderPane mainLayout;
	BorderPane topLayout;
	BorderPane centerLeftLayout;
	BorderPane centerLayout;
	BorderPane centerRightLayout;
	
	public static void main(String[] args) {
        launch(args);
    } // main
	
	//Image method
	public VBox getImage(Image image, VBox getImage) throws Exception{
		//Group root = new Group();
		ImageView insertImage = new ImageView();
    	insertImage.setImage(image);
    	insertImage.setFitWidth(300);
    	insertImage.setFitHeight(300);
    	getImage.getChildren().add(insertImage);
    	//root.getChildren().add(getImage);
		return getImage;
	}
	
	//Bottom button method
	public VBox bottomMenu(VBox bottomMenu) throws Exception{
		//button padding
    	bottomMenu.setPadding(new Insets(12));
    	bottomMenu.setSpacing(10);
    	//button
    	Button rotate = new Button("Rotate");
    	rotate.setOnAction(e -> System.out.println("ROTATE")); //setOnActive ROTATE
    	Button reset = new Button("reset");
    	reset.setOnAction(e -> System.out.println("RESET")); //setOnAction RESET
    	bottomMenu.getChildren().addAll(rotate, reset);
    	bottomMenu.setAlignment(Pos.BOTTOM_LEFT);
    	return bottomMenu;
    }
	
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
    	//button padding
	    topMenu.setPadding(new Insets(15, 12, 15, 12));
	    topMenu.setSpacing(10);
	    //buttons
	    Button checkers = new Button("Checkers");
	    checkers.setOnAction(e -> System.out.println("CHECKERS")); //setOnAction CHECKERS
    	Button horizontalStripes = new Button("Horizontal Stripes");
    	horizontalStripes.setOnAction(e -> System.out.println("HORIZONTAL STRIPES")); //setOnAction HORIZONTAL STRIPES
    	Button verticalStripes = new Button("Vertical Stripes");
    	verticalStripes.setOnAction(e -> System.out.println("VERTICAL STRIPES")); //setOnAction VERTICAL STRIPES
    	topMenu.getChildren().addAll(checkers, horizontalStripes, verticalStripes);
    	
    	//Image
    	Image imageImport1 = new Image("file:samples/sample1.png");
    	Image imageImport2 = new Image("file:samples/sample2.png");
    	VBox leftImage = new VBox();
    	//image title 1
    	Text imageTitle1 = new Text("Image 1 : " + "sameple1.png"); //update image file name
    	leftImage.getChildren().add(imageTitle1);
    	//image padding 1
    	leftImage.setPadding(new Insets(7, 6, 7, 6));
	    leftImage.setSpacing(5);
    	getImage(imageImport1, leftImage);
    	VBox centerImage = new VBox();
    	//image title 2
    	Text imageTitle2 = new Text("Image 2 : " + "sample1.png"); //update image file name
    	centerImage.getChildren().add(imageTitle2);
    	//image padding 2
    	centerImage.setPadding(new Insets(7, 6, 7, 6));
	    centerImage.setSpacing(5);
    	getImage(imageImport2, centerImage);
    	VBox rightImage = new VBox();
    	//result title
    	Text resultTitle = new Text("Result");
    	rightImage.getChildren().add(resultTitle);
    	//result padding
    	rightImage.setPadding(new Insets(7, 6, 7, 6));
	    rightImage.setSpacing(5);
    	getImage(imageImport1, rightImage);
    	
    	//Bottom buttons
    	VBox bottomLeftMenu = new VBox();
    	bottomMenu(bottomLeftMenu);
    	VBox bottomCenterMenu = new VBox();
    	bottomMenu(bottomCenterMenu);
    	VBox bottomRightMenu = new VBox();
    	bottomMenu(bottomRightMenu);
    	
    	topLayout = new BorderPane();
    	centerLeftLayout = new BorderPane();
    	centerLayout = new BorderPane();
    	centerRightLayout = new BorderPane();
    	topLayout.setTop(menuBar);
    	topLayout.setBottom(topMenu);
    	centerLeftLayout.setTop(leftImage);
    	centerLeftLayout.setBottom(bottomLeftMenu);
    	centerLayout.setTop(centerImage);
    	centerLayout.setBottom(bottomCenterMenu);
    	centerRightLayout.setTop(rightImage);
    	centerRightLayout.setBottom(bottomRightMenu);
    	
    	mainLayout = new BorderPane();
    	mainLayout.setTop(topLayout);
    	mainLayout.setLeft(centerLeftLayout);
    	mainLayout.setCenter(centerLayout);
    	mainLayout.setRight(centerRightLayout);
    	
    	Scene scene = new Scene(mainLayout, 935, 500);
    	window.setScene(scene);
    	window.show();
    } // createAndShowGUI

} // Driver
