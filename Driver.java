package main.java.cs1302.p2;

import main.java.cs1302.effects.Artsy;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
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
	File imageFile1;
	File imageFile2;
	String fileName1 = "default.png";
	String fileName2 = "default.png";
	Image imageImport1 = new Image("file:resources/default.png");
	Image imageImport2 = new Image("file:resources/default.png");
	Image imageResult = new Image("file:resources/default.png");
	ImageView insertImage;
	static int answer;
	int rotateBoxReturnValue;
	
	public static void main(String[] args) {
        launch(args);
    } // main
	
	//Image method
	public VBox getImage(Image image, VBox getImage) throws Exception{
		insertImage = new ImageView();
    	insertImage.setImage(image);
    	insertImage.setFitWidth(300);
    	insertImage.setFitHeight(300);
    	getImage.getChildren().add(insertImage);
    	
		return getImage;
	}
	
	//Bottom button method
	public VBox bottomMenu(VBox bottomMenu) throws Exception{
		//button padding
    	bottomMenu.setPadding(new Insets(12));
    	bottomMenu.setSpacing(10);
    	//button
    	Button rotate = new Button("Rotate");
    	rotate.setOnAction(e -> {
    		rotateBoxReturnValue = rotateBox("Rotate Image Options", "Please enter your angle, in degress.");
    		
    	}); //setOnActive ROTATE
    	Button reset = new Button("Reset");
    	reset.setOnAction(e -> System.out.println("RESET")); //setOnAction RESET
    	bottomMenu.getChildren().addAll(rotate, reset);
    	bottomMenu.setAlignment(Pos.BOTTOM_LEFT);
    	return bottomMenu;
    }
	
	//RotateBox window
	public static int rotateBox(String title, String message){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		//window.setMinWidth(250);
		Label label = new Label();
		label.setText(message);
		
		VBox answerBox = new VBox();
		
		//Text Field
		final TextField textField = new TextField();
		textField.setPromptText("Enter your angel, in degrees.");
		answerBox.setSpacing(10);
		
		//Buttons
		Button cancel = new Button("Cancel");
		Button ok = new Button("Ok");
		
		ok.setOnAction(e -> {
			
			String stringToInt = textField.getText();
			if((textField.getText() != null && !textField.getText().isEmpty())) {
				answer = Integer.parseInt(stringToInt);
				window.close();
			}
			else {
				label.setText("You have not entered your angel, in degrees.");
			}
		});
		cancel.setOnAction(e -> window.close());
		
		answerBox.getChildren().add(label);
		answerBox.getChildren().add(textField);
		answerBox.getChildren().add(cancel);
		answerBox.getChildren().add(ok);
		answerBox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(answerBox, 300, 150);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}
	
    @Override
    public void start(Stage stage) throws Exception {
    	VBox leftImage = new VBox();
    	VBox centerImage = new VBox();
    	VBox rightImage = new VBox();
    	window = stage;
    	window.setTitle("Artsy");
    	
    	//File chooser
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    	
    	//File menu
    	Menu fileMenu = new Menu("File");
    	
    	//Menu item
    	Menu open = new Menu("Open");
    	MenuItem subMenuImage1 = new MenuItem("Open Image 1");
    	//Open Image 1
    	subMenuImage1.setOnAction(new EventHandler<ActionEvent>(){
    		
			@Override
			public void handle(ActionEvent event) {
			
				//Set extension filter
		    	FileChooser.ExtensionFilter extFilterBMP = new FileChooser.ExtensionFilter("BMP files (*.bmp)", "*.BMP");
		    	FileChooser.ExtensionFilter extFilterGIF = new FileChooser.ExtensionFilter("GIF files (*.gif)", "*.GIF");
		        FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");
		        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
		        fileChooser.getExtensionFilters().addAll(extFilterBMP, extFilterGIF, extFilterJPEG, extFilterPNG);
		        
		        fileName1 = fileChooser.getInitialFileName();
				imageFile1 = fileChooser.showOpenDialog(null);
				
				try {
	                BufferedImage bufferedImage = ImageIO.read(imageFile1);
	                imageImport1 = SwingFXUtils.toFXImage(bufferedImage, null);
	                insertImage.setImage(imageImport1);
	            } catch (IOException ex) {
	                System.out.println("Image did not load.");
	            }
			}
    	});
    	open.getItems().add(subMenuImage1);
    	MenuItem subMenuImage2 = new MenuItem("Open Image 2");
    	subMenuImage2.setOnAction(new EventHandler<ActionEvent>(){
    		
			@Override
			public void handle(ActionEvent event) {
			
				//Set extension filter
		    	FileChooser.ExtensionFilter extFilterBMP = new FileChooser.ExtensionFilter("BMP files (*.bmp)", "*.BMP");
		    	FileChooser.ExtensionFilter extFilterGIF = new FileChooser.ExtensionFilter("GIF files (*.gif)", "*.GIF");
		        FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");
		        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
		        fileChooser.getExtensionFilters().addAll(extFilterBMP, extFilterGIF, extFilterJPEG, extFilterPNG);
		        
				imageFile2 = fileChooser.showOpenDialog(null);
				
				try {
	                BufferedImage bufferedImage = ImageIO.read(imageFile2);
	                imageImport2 = SwingFXUtils.toFXImage(bufferedImage, null);
	                insertImage.setImage(imageImport2);
	            } catch (IOException ex) {
	                System.out.println("Image did not load.");
	            }
			}
    	}); //setOnAction IMAGE 2
        open.getItems().add(subMenuImage2);
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
    	//image title 1
    	Text imageTitle1 = new Text("Image 1 : " + fileName1); //update image file name
    	leftImage.getChildren().add(imageTitle1);
    	//image padding 1
    	leftImage.setPadding(new Insets(7, 6, 7, 6));
	    leftImage.setSpacing(5);
    	getImage(imageImport1, leftImage);
    	
    	//image title 2
    	Text imageTitle2 = new Text("Image 2 : " + fileName2); //update image file name
    	centerImage.getChildren().add(imageTitle2);
    	//image padding 2
    	centerImage.setPadding(new Insets(7, 6, 7, 6));
	    centerImage.setSpacing(5);
    	getImage(imageImport2, centerImage);
    	
    	//result title
    	Text resultTitle = new Text("Result");
    	rightImage.getChildren().add(resultTitle);
    	//result padding
    	rightImage.setPadding(new Insets(7, 6, 7, 6));
	    rightImage.setSpacing(5);
    	getImage(imageResult, rightImage);
    	
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
