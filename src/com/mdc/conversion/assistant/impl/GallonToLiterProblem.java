package com.mdc.conversion.assistant.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import com.mdc.conversion.assistant.ProblemHandler;

public class GallonToLiterProblem extends ProblemHandler {

	/**
	 * Image of a bottle.
	 */
	private Image bottle;
	
	public GallonToLiterProblem() {
		super(4);
		try {
			bottle = new Image(new FileInputStream("./data/images/liter.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onStart(Pane layout) {
		switch(stage)
		{
		case 1:
			layout.getChildren().add(new Text("In this problem we will be converting gallons to liter"));
			layout.getChildren().add(new Text("Solve the following. How many liters are in 29 gallons?"));
			break;
		case 2:
			layout.getChildren().add(new Text("First we must know that there are 0.946353 liters in a quart"));
			layout.getChildren().add(new Text("Then we must know that there are 4 quarts in a gallon"));
			break;
		case 3:
			layout.getChildren().add(new Text("We do the following equation."));
			layout.getChildren().add(new Text("4 x 0.946353 = 3.78541 Liters"));
			layout.getChildren().add(new Text("3.78541 = 1 gallon"));
			layout.getChildren().add(new Text("28 x 3.78541 = 105.992 liters"));
			break;
		case 4:
			layout.getChildren().add(new Text("Answer: 105.992 liters"));
			layout.getChildren().add(new ImageView(bottle));
			break;
		}
	}

}
