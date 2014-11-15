package com.mdc;

import java.util.logging.Logger;

import com.mdc.conversion.Unit;

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
import javafx.stage.Stage;

public class Calculator extends Application {

	private Group widgetContainer;

	private ComboBox<String> unitTypeCombobox;
	private ComboBox<String> firstUnitSelector;

	/**
	 * Combo box that contains the measurement type unit.
	 */
	private ObservableList<String> unitType = FXCollections
			.observableArrayList("Mass", "Volume", "Length", "Time");

	private ObservableList<String> englishUnits = FXCollections
			.observableArrayList();
	private ObservableList<String> metricUnits = FXCollections
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
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.show();

		unitTypeCombobox = new ComboBox<>(unitType);
		firstUnitSelector = new ComboBox<>(englishUnits);

		unitTypeCombobox.setTranslateX(80);
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
		widgetContainer.getChildren().add(menuBar);

		Scene primaryScene = new Scene(widgetContainer);

		primaryStage.setScene(primaryScene);
	}

	void setupLogic() {
		unitTypeCombobox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent action) {
				System.out.println(unitTypeCombobox.getValue());
				System.out.println(Unit.getEnglishUnit(unitTypeCombobox
						.getValue()));
				firstUnitSelector.setItems(FXCollections
						.observableArrayList(Unit
								.getEnglishUnit(unitTypeCombobox.getValue())));
			}

		});
	}

}
