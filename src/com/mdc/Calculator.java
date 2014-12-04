package com.mdc;

import java.util.logging.Logger;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import com.mdc.conversion.Unit;
import com.mdc.conversion.UnitConverter;
import com.mdc.conversion.assistant.ProblemManager;
import com.mdc.util.TrfParser;

/**
 * Creates a new Calculator application.
 * @author Tony Erazo
 * @author Ronny
 *
 */
public class Calculator extends Application {

	/**
	 * Contains all our components in our stage.
	 */
	private Group widgetContainer;

	/**
	 * Conversion type box selector.
	 */
	private ComboBox<String> unitTypeCombobox;
	
	/**
	 * Frist unit selection box for the conversion type.
	 */
	private ComboBox<String> firstUnitSelector;
	
	/**
	 * Second unit selection box for the conversion type.
	 */
	private ComboBox<String> secondUnitSelector;
	
	/**
	 * First textfield where the user inputs the value they would like to convert.
	 */
	private TextField firstUnitTextField;
	
	/**
	 * Second textfield that shows the conversion value.
	 */
	private TextField secondUnitTextField;

	/**
	 * Combo box that contains the measurement type unit.
	 */
	private ObservableList<String> unitType = FXCollections
			.observableArrayList("Mass", "Volume", "Length", "Time");
	
	/**
	 * About Menu Item binded to the help menu.
	 */
	private MenuItem aboutMenuItem;
	
	/**
	 * Problem Assistant Menu Item binded to the help menu.
	 */
	private MenuItem problemAssistantMenuItem;

	/**
	 * Logs the events occuring within the entry point class.
	 */
	private static Logger logger = Logger.getLogger(Calculator.class.getName());

	/**
	 * Trf parser.
	 */
	private TrfParser parser = new TrfParser();
	
	/**
	 * Manages the problem handlers.
	 */
	private ProblemManager manager = new ProblemManager();
	/**
	 * Entry-point of the application.
	 * 
	 * @param args
	 *            command-line arguments.
	 */
	public static void main(String[] args) {
		logger.info("Initializing application...");
		Calculator.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(Settings.APPLICATION_NAME);
		primaryStage.setWidth(Settings.SCREEN_WIDTH);
		primaryStage.setHeight(Settings.SCREEN_HEIGHT);
		primaryStage.show();
		
		parser.loadHandlers();

		unitTypeCombobox = new ComboBox<>(unitType);
		secondUnitSelector = new ComboBox<>();
		firstUnitSelector = new ComboBox<>();
		
		firstUnitTextField = new TextField();
		secondUnitTextField = new TextField();
		
		firstUnitTextField.setEditable(false);
		secondUnitTextField.setEditable(false);
		
		firstUnitTextField.setTranslateX(100);
		firstUnitTextField.setTranslateY(40);
		
		secondUnitTextField.setTranslateX(300);
		secondUnitTextField.setTranslateY(40);
		
		unitTypeCombobox.setTranslateX(190);
		
		secondUnitSelector.setTranslateX(300);
		secondUnitSelector.setTranslateY(100);
		
		firstUnitSelector.setTranslateX(100);
		firstUnitSelector.setTranslateY(100);

		Menu helpmenu = new Menu("Help");
		aboutMenuItem = new MenuItem("About");
		problemAssistantMenuItem = new MenuItem("Problem Assistant");
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(helpmenu);
		menuBar.setUseSystemMenuBar(true);
		helpmenu.getItems().add(problemAssistantMenuItem);
		helpmenu.getItems().add(aboutMenuItem);

		setupLogic(primaryStage);

		widgetContainer = new Group();
		widgetContainer.getChildren().add(firstUnitSelector);
		widgetContainer.getChildren().add(unitTypeCombobox);
		widgetContainer.getChildren().add(secondUnitSelector);
		
		widgetContainer.getChildren().add(firstUnitTextField);
		widgetContainer.getChildren().add(secondUnitTextField);
		
		widgetContainer.getChildren().add(menuBar);

		Scene primaryScene = new Scene(widgetContainer);

		 new AnimationTimer() {

			@Override
			public void handle(long delta) {
				if(firstUnitTextField.isEditable())
				{
					if(!firstUnitTextField.getText().isEmpty())
					{
						try
						{
							secondUnitTextField.setText(String.valueOf(UnitConverter.convert(unitTypeCombobox.getValue(),
									firstUnitSelector.getValue(), Double.parseDouble(firstUnitTextField.getText()), secondUnitSelector.getValue())));	
						}
						catch(NumberFormatException e)
						{
							if(firstUnitTextField.getText().contains("."))
							{
								firstUnitTextField.setText("0");
							}
							e.printStackTrace();
						}
					}
				}
			}
			 
		 }.start();
		primaryStage.setScene(primaryScene);
	}

	/**
	 * Adds the logic/handlers for all of our components.
	 */
	void setupLogic(Stage primaryStage) {

		problemAssistantMenuItem.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) {
						final Stage comingSoonDialog = new Stage();
						final Button nextButton = new Button("Next");
						
						ListView<String> list = new ListView<String>();
						
						
						ObservableList<String> items =FXCollections.observableArrayList(parser.getHandlerNames());
						list.setItems(items);
						
						VBox handlerLayout = new VBox();
						handlerLayout.setTranslateX(250);
						nextButton.setTranslateX(320);
						nextButton.setTranslateY(370);
	
						list.setOnMouseClicked(new EventHandler<MouseEvent>()
								{

									@Override
									public void handle(MouseEvent event) 
									{
										if(event.getClickCount() == 2)
										{
											if(!handlerLayout.getChildren().isEmpty() && manager.hadPreviousHandler())
												handlerLayout.getChildren().clear();
											manager.submit(parser.getHandlers().get(list.getSelectionModel().getSelectedItem()), handlerLayout);	
										}
									}
							
								});
						nextButton.setOnMouseClicked(new EventHandler<MouseEvent>()
								{

									@Override
									public void handle(MouseEvent event) {
										manager.next();
										manager.submit(parser.getHandlers().get(list.getSelectionModel().getSelectedItem()), handlerLayout);
									}
							
								});
						
		                comingSoonDialog.initModality(Modality.WINDOW_MODAL);
		                comingSoonDialog.setTitle("Problem Assistant");
		                comingSoonDialog.initOwner(primaryStage);

		               // dialogVbox.setAlignment(Pos.CENTER);
		                Group group = new Group();
		            
		                group.getChildren().add(list);
		                group.getChildren().add(nextButton);
		                group.getChildren().add(handlerLayout);
		            
		                Scene aboutDialogScene = new Scene(group, 500, 400);
		                comingSoonDialog.setScene(aboutDialogScene);
		                comingSoonDialog.show();
					}
			
				});
		aboutMenuItem.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) {
						final Stage aboutDialog = new Stage();
						final Button okButton = new Button("Ok");
						
						okButton.setOnMouseClicked(new EventHandler<MouseEvent>()
								{

									@Override
									public void handle(MouseEvent event) {
										aboutDialog.close();
									}
							
								});
						
		                aboutDialog.initModality(Modality.WINDOW_MODAL);
		                aboutDialog.setTitle("About");
		                aboutDialog.initOwner(primaryStage);
		                VBox dialogVbox = new VBox(20);
		                dialogVbox.getChildren().add(new Text("The purpose of this application is to provide students a \nfriendly and accurate way to solve conversion problems.\n"+
		                "The calculator will display the steps taken, thus assisting\n the student in solving a specific conversion problem\n." +  
		                "It may also guide students to learning conversion.\n This application will also provide a help section that\n will provide " +
		                "an easy “how to use” section that will \nexplain how to use the application.\n We believe "+
		                "conversion is a vital topic in chemistry and\n other science courses,\n it should be well "+
		                "understood as it is elaborated\n later on other subjects such as calorimetry, \nfactorization "+
		                		"conversion and much more"));
		                dialogVbox.setAlignment(Pos.CENTER);
		                dialogVbox.getChildren().add(okButton);
		                Scene aboutDialogScene = new Scene(dialogVbox, 320, 260);
		                aboutDialog.setScene(aboutDialogScene);
		                aboutDialog.show();
					}
			
				});
		
		unitTypeCombobox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent action) {
				firstUnitSelector.setItems(FXCollections
						.observableArrayList(Unit
								.getAllUnits(unitTypeCombobox.getValue())));
				
				secondUnitSelector.setItems(FXCollections
						.observableArrayList(Unit
								.getAllUnits(unitTypeCombobox.getValue())));
				
				firstUnitSelector.setValue(FXCollections
						.observableArrayList(Unit
								.getAllUnits(unitTypeCombobox.getValue())).get(0));
				
				secondUnitSelector.setValue(FXCollections
						.observableArrayList(Unit
								.getAllUnits(unitTypeCombobox.getValue())).get(0));
				
				firstUnitTextField.setEditable(true);
				secondUnitTextField.setEditable(true);
				
				firstUnitTextField.setText("0");
				secondUnitTextField.setText("0");
			}

		});

	}

}
