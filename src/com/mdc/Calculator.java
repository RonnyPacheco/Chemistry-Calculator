package com.mdc;

import java.util.logging.Logger;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.mdc.conversion.Unit;
import com.mdc.conversion.UnitConverter;

public class Calculator extends Application {

	private Group widgetContainer;

	private ComboBox<String> unitTypeCombobox;
	private ComboBox<String> firstUnitSelector;
	private ComboBox<String> secondUnitSelector;
	
	private TextField firstUnitTextField;
	private TextField secondUnitTextField;

	/**
	 * Combo box that contains the measurement type unit.
	 */
	private ObservableList<String> unitType = FXCollections
			.observableArrayList("Mass", "Volume", "Length", "Time");

	private ObservableList<String> englishUnits = FXCollections
			.observableArrayList();

	/**
	 * Logs the events occuring within the entry point class.
	 */
	private static Logger logger = Logger.getLogger(Calculator.class.getName());

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
		primaryStage.setWidth(500);
		primaryStage.setHeight(200);
		primaryStage.show();

		unitTypeCombobox = new ComboBox<>(unitType);
		secondUnitSelector = new ComboBox<>(englishUnits);
		firstUnitSelector = new ComboBox<>(englishUnits);
		
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

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(helpmenu);
		menuBar.setUseSystemMenuBar(true);

		setupLogic();

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
							System.out.println(UnitConverter.convert(
									firstUnitSelector.getValue(), Double.parseDouble(firstUnitTextField.getText()), secondUnitSelector.getValue()));
							secondUnitTextField.setText(String.valueOf(UnitConverter.convert(
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

	void setupLogic() {
		unitTypeCombobox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent action) {
				System.out.println(unitTypeCombobox.getValue());
				System.out.println(Unit.getAllUnits(unitTypeCombobox
						.getValue()));
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
