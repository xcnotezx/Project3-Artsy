package main.java.cs1302.p2;

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
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
	Text imageTitle1;
	Text imageTitle2;
	Image defaultImage = new Image("file:resources/default.png");
	Image imageImport1 = new Image("file:resources/default.png");
	Image imageImport1Display = new Image("file:resources/default.png");
	Image imageImport2 = new Image("file:resources/default.png");
	Image imageImport2Display = new Image("file:resources/default.png");
	Image imageResult = new Image("file:resources/default.png");
	Image imageResultDisplay = new Image("file:resources/default.png");
	ImageView viewImage1;
	ImageView viewImage2;
	ImageView viewResults;
	static int rotateInput;
	static int checkersInput;
	static int horizontalInput;
	static int verticalInput;
	int rotateBoxReturnValue;
	int checkersBoxReturnValue;
	int horizontalBoxReturnValue;
	int verticalBoxReturnValue;
	MyArtsy ma = new MyArtsy();
	
	public static void main(String[] args) {
        launch(args);
    } // main
	
//CheckersBox window
	public static int checkersBox(String title, String message){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		//window.setMinWidth(250);
		Label label = new Label();
		label.setText(message);
		
		VBox answerBox = new VBox();
		
		//Text Field
		final TextField textField = new TextField();
		textField.setPromptText("Enter the desired checker width, in pixels.");
		answerBox.setSpacing(10);
		
		//Buttons
		Button cancel = new Button("Cancel");
		Button ok = new Button("Ok");
		
		ok.setOnAction(e -> {
			
			String stringToInt = textField.getText();
			if((stringToInt != null && !textField.getText().isEmpty())) {
				if(textField.getText().matches("[0-9]*")) {
					checkersInput = Integer.parseInt(stringToInt);
					window.close();
				}
				else {
					label.setText("You have not entered checker width, in pixels.");
				}
			}
			else {
				label.setText("You have not entered checker width, in pixels");
			}
		});
		cancel.setOnAction(e ->{
			checkersInput = -1;
			window.close();
		});
		
		answerBox.getChildren().add(label);
		answerBox.getChildren().add(textField);
		answerBox.getChildren().add(cancel);
		answerBox.getChildren().add(ok);
		answerBox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(answerBox, 300, 150);
		window.setScene(scene);
		window.showAndWait();
		
		return checkersInput;
	}
	
	//HorizontalBox window
	public static int horizontalBox(String title, String message){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		//window.setMinWidth(250);
		Label label = new Label();
		label.setText(message);
		
		VBox answerBox = new VBox();
		
		//Text Field
		final TextField textField = new TextField();
		textField.setPromptText("Enter the desired stripe height, in pixels.");
		answerBox.setSpacing(10);
		
		//Buttons
		Button cancel = new Button("Cancel");
		Button ok = new Button("Ok");
		
		ok.setOnAction(e -> {
			
			String stringToInt = textField.getText();
			if((stringToInt != null && !textField.getText().isEmpty())) {
				if(textField.getText().matches("[0-9]*")) {
					horizontalInput = Integer.parseInt(stringToInt);
					window.close();
				}
				else {
					label.setText("You have not entered stripe height, in pixels.");
				}
			}
			else {
				label.setText("You have not entered stripe height, in pixels");
			}
		});
		cancel.setOnAction(e -> {
			horizontalInput = -1;
			window.close();
		});
		
		answerBox.getChildren().add(label);
		answerBox.getChildren().add(textField);
		answerBox.getChildren().add(cancel);
		answerBox.getChildren().add(ok);
		answerBox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(answerBox, 350, 150);
		window.setScene(scene);
		window.showAndWait();
		
		return horizontalInput;
	}
	
	//VerticalBox window
	public static int verticalBox(String title, String message){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		//window.setMinWidth(250);
		Label label = new Label();
		label.setText(message);
		
		VBox answerBox = new VBox();
		
		//Text Field
		final TextField textField = new TextField();
		textField.setPromptText("Enter the desired stripe width, in pixels.");
		answerBox.setSpacing(10);
		
		//Buttons
		Button cancel = new Button("Cancel");
		Button ok = new Button("Ok");
		
		ok.setOnAction(e -> {
			
			String stringToInt = textField.getText();
			if((stringToInt != null && !textField.getText().isEmpty())) {
				if(textField.getText().matches("[0-9]*")) {
					verticalInput = Integer.parseInt(stringToInt);
					window.close();
				}
				else {
					label.setText("You have not entered stripe width, in pixels.");
				}
			}
			else {
				label.setText("You have not entered stripe width, in pixels");
			}
		});
		cancel.setOnAction(e -> {
			verticalInput = -1;
			window.close();
		});
		
		answerBox.getChildren().add(label);
		answerBox.getChildren().add(textField);
		answerBox.getChildren().add(cancel);
		answerBox.getChildren().add(ok);
		answerBox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(answerBox, 300, 150);
		window.setScene(scene);
		window.showAndWait();
		
		return verticalInput;
	}
	
	//Bottom left button method
	public VBox bottomLeftMenu(VBox bottomMenu) throws Exception{
		//button padding
    	bottomMenu.setPadding(new Insets(12));
    	bottomMenu.setSpacing(10);
    	//button
    	Button rotate = new Button("Rotate");
    	rotate.setOnAction(e -> {
    		rotateBoxReturnValue = rotateBox("Rotate Image Options", "Please enter your angle, in degress.");
    		if(rotateBoxReturnValue == -1){
    			
    		}
    		else{
        		imageImport1Display = ma.doRotate(imageImport1Display, rotateBoxReturnValue);
        		viewImage1.setImage(imageImport1Display);
    		}
    	}); //setOnActive ROTATE
    	
    	Button reset = new Button("Reset");
    	reset.setOnAction(e ->{
    		imageImport1Display = imageImport1;
    		viewImage1.setImage(imageImport1Display);
    		System.out.println("RESET");
    	}); //setOnAction RESET
    	
    	bottomMenu.getChildren().addAll(rotate, reset);
    	bottomMenu.setAlignment(Pos.BOTTOM_LEFT);
    	return bottomMenu;
    }
	
	//Bottom center button method
	public VBox bottomCenterMenu(VBox bottomMenu) throws Exception{
		//button padding
    	bottomMenu.setPadding(new Insets(12));
    	bottomMenu.setSpacing(10);
    	//button
    	Button rotate = new Button("Rotate");
    	rotate.setOnAction(e -> {
    		rotateBoxReturnValue = rotateBox("Rotate Image Options", "Please enter your angle, in degress.");
    		if(rotateBoxReturnValue == -1){
    			
    		}
    		else{
        		imageImport2Display = ma.doRotate(imageImport2Display, rotateBoxReturnValue);
        		viewImage2.setImage(imageImport2Display);
    		}
    	}); //setOnActive ROTATE
    	Button reset = new Button("Reset");
    	reset.setOnAction(e ->{
    		imageImport2Display = imageImport2;
    		viewImage2.setImage(imageImport2Display);
    		System.out.println("RESET");
    	}); //setOnAction RESET
    	bottomMenu.getChildren().addAll(rotate, reset);
    	bottomMenu.setAlignment(Pos.BOTTOM_LEFT);
    	return bottomMenu;
    }
	
	//Bottom right button method
	public VBox bottomRightMenu(VBox bottomMenu) throws Exception{
		//button padding
    	bottomMenu.setPadding(new Insets(12));
    	bottomMenu.setSpacing(10);
    	//button
    	Button rotate = new Button("Rotate");
    	rotate.setOnAction(e -> {
    		rotateBoxReturnValue = rotateBox("Rotate Image Options", "Please enter your angle, in degress.");
    		if(rotateBoxReturnValue == -1){
    			
    		}
    		else{
        		imageResultDisplay = ma.doRotate(imageResultDisplay, rotateBoxReturnValue);
        		viewResults.setImage(imageResultDisplay);
    		}
    	}); //setOnActive ROTATE
    	Button reset = new Button("Reset");
    	reset.setOnAction(e ->{
    		imageResult = defaultImage;
    		imageResultDisplay = imageResult;
    		viewResults.setImage(imageResultDisplay);
    		System.out.println("RESET");
    	}); //setOnAction RESET
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
		textField.setPromptText("Enter your angle, in degrees.");
		answerBox.setSpacing(10);
		
		//Buttons
		Button cancel = new Button("Cancel");
		Button ok = new Button("Ok");
		
		ok.setOnAction(e -> {
			
			String stringToInt = textField.getText();
			if((stringToInt != null && !textField.getText().isEmpty())) {
				if(textField.getText().matches("[0-9]*")) {
					rotateInput = Integer.parseInt(stringToInt);
					window.close();
				}
				else {
					label.setText("You have not entered your angel, in degrees.");
				}
			}
			else {
				label.setText("You have not entered your angel, in degrees.");
			}
		});
		cancel.setOnAction(e -> {
			rotateInput = -1;
			window.close();
		});
		
		answerBox.getChildren().add(label);
		answerBox.getChildren().add(textField);
		answerBox.getChildren().add(cancel);
		answerBox.getChildren().add(ok);
		answerBox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(answerBox, 300, 150);
		window.setScene(scene);
		window.showAndWait();
		
		return rotateInput;
	}
	
    @Override
    public void start(Stage stage) throws Exception {
    	VBox leftImage = new VBox();
    	VBox centerImage = new VBox();
    	VBox rightImage = new VBox();
    	window = stage;
    	window.setTitle("Artsy");
    	
    	//File chooser
    	FileChooser fileChooser1 = new FileChooser();
    	FileChooser fileChooser2 = new FileChooser();
    	fileChooser1.setTitle("Open Resource File");
    	fileChooser2.setTitle("Open Resource File");
    	
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
		        fileChooser1.getExtensionFilters().addAll(extFilterBMP, extFilterGIF, extFilterJPEG, extFilterPNG);
		        
				imageFile1 = fileChooser1.showOpenDialog(null);
				
				try {
	                BufferedImage bufferedImage = ImageIO.read(imageFile1);
	                imageImport1 = SwingFXUtils.toFXImage(bufferedImage, null);
	                imageImport1Display = SwingFXUtils.toFXImage(bufferedImage, null);
	                viewImage1.setImage(imageImport1);
	                fileName1 = imageFile1.getName();
	                imageTitle1.setText("Image 1 : " + fileName1);
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
		        fileChooser2.getExtensionFilters().addAll(extFilterBMP, extFilterGIF, extFilterJPEG, extFilterPNG);
		        
				imageFile2 = fileChooser2.showOpenDialog(null);
				
				try {
	                BufferedImage bufferedImage = ImageIO.read(imageFile2);
	                imageImport2 = SwingFXUtils.toFXImage(bufferedImage, null);
	                imageImport2Display = SwingFXUtils.toFXImage(bufferedImage, null);
	                viewImage2.setImage(imageImport2);
	                fileName2 = imageFile2.getName();
	                imageTitle2.setText("Image 2 : " + fileName2);
	            } catch (IOException ex) {
	                System.out.println("Image did not load.");
	            }
			}
    	}); //setOnAction IMAGE 2
        open.getItems().add(subMenuImage2);
        fileMenu.getItems().add(open);
    	fileMenu.getItems().add(new SeparatorMenuItem());
    	MenuItem saveResultAs = new MenuItem("Save Result As");
    	saveResultAs.setOnAction(new EventHandler<ActionEvent>(){
    		
    		@Override
			public void handle(ActionEvent event) {
    			FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save Image");
                File file = fileChooser.showSaveDialog(stage);
                if (file != null) {
                    try {
                        ImageIO.write(SwingFXUtils.fromFXImage(imageResultDisplay, null), "png", file);
                    } catch (IOException ex) {
                        System.out.println("Image did not save.");
                    }
                }
    		}
    	}); //setOnAction SAVE RESULTS AS
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
	    checkers.setOnAction(e -> {
    		checkersBoxReturnValue = checkersBox("Checkers Options", "Please enter the desired checker width, in pixels.");
    		if (checkersBoxReturnValue == -1){
    			
    		}
    		else{
    			imageResult = ma.doCheckers(imageImport1Display, imageImport2Display, checkersBoxReturnValue);
    			imageResultDisplay = ma.doCheckers(imageImport1Display, imageImport2Display, checkersBoxReturnValue);
    			viewResults.setImage(imageResultDisplay);
    		}
	    }); //setOnAction CHECKERS
    	Button horizontalStripes = new Button("Horizontal Stripes");
    	horizontalStripes.setOnAction(e -> {
    		horizontalBoxReturnValue = horizontalBox("Horizontal Stripe Options", "Please enter the desired stripe height, in pixels.");
    		if (horizontalBoxReturnValue == -1){
    			
    		}
    		else{
    			imageResult = ma.doHorizontalStripes(imageImport1Display, imageImport2Display, horizontalBoxReturnValue);
    			imageResultDisplay = ma.doHorizontalStripes(imageImport1Display, imageImport2Display, horizontalBoxReturnValue);
    			viewResults.setImage(imageResultDisplay);
    		}
    	}); //setOnAction HORIZONTAL STRIPES
    	Button verticalStripes = new Button("Vertical Stripes");
    	verticalStripes.setOnAction(e -> {
    		verticalBoxReturnValue = verticalBox("Vertical Stripe Options", "Please enter the desired stripe width, in pixels.");
    		if(verticalBoxReturnValue == -1){
    			
    		}
    		else{
    			imageResult = ma.doVerticalStripes(imageImport1Display, imageImport2Display, verticalBoxReturnValue);
    			imageResultDisplay = ma.doVerticalStripes(imageImport1Display, imageImport2Display, verticalBoxReturnValue);
    			viewResults.setImage(imageResultDisplay);
    		}
	    }); //setOnAction VERTICAL STRIPES
    	topMenu.getChildren().addAll(checkers, horizontalStripes, verticalStripes);
    	
    	//Image
    	//image title 1
    	imageTitle1 = new Text("Image 1 : " + fileName1); //update image file name
    	leftImage.getChildren().add(imageTitle1);
    	//image padding 1
    	leftImage.setPadding(new Insets(7, 6, 7, 6));
	    leftImage.setSpacing(5);
	    viewImage1 = new ImageView();
    	viewImage1.setImage(imageImport1Display);
    	viewImage1.setFitWidth(300);
    	viewImage1.setFitHeight(300);
    	leftImage.getChildren().add(viewImage1);
    	
    	//image title 2
    	imageTitle2 = new Text("Image 2 : " + fileName2); //update image file name
    	centerImage.getChildren().add(imageTitle2);
    	//image padding 2
    	centerImage.setPadding(new Insets(7, 6, 7, 6));
	    centerImage.setSpacing(5);
	    viewImage2 = new ImageView();
    	viewImage2.setImage(imageImport2Display);
    	viewImage2.setFitWidth(300);
    	viewImage2.setFitHeight(300);
    	centerImage.getChildren().add(viewImage2);
    	
    	//result title
    	Text resultTitle = new Text("Result");
    	rightImage.getChildren().add(resultTitle);
    	//result padding
    	rightImage.setPadding(new Insets(7, 6, 7, 6));
	    rightImage.setSpacing(5);
	    viewResults = new ImageView();
    	viewResults.setImage(imageResultDisplay);
    	viewResults.setFitWidth(300);
    	viewResults.setFitHeight(300);
    	rightImage.getChildren().add(viewResults);
    	
    	//Bottom buttons
    	VBox bottomLeftMenu = new VBox();
    	bottomLeftMenu(bottomLeftMenu);
    	VBox bottomCenterMenu = new VBox();
    	bottomCenterMenu(bottomCenterMenu);
    	VBox bottomRightMenu = new VBox();
    	bottomRightMenu(bottomRightMenu);
    	
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
