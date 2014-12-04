package com.mdc.conversion.assistant.impl;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import com.mdc.conversion.assistant.ProblemHandler;

/**
 * Sample problem showing how to convert cups to pint.
 * @author Tony Erazo
 * @author Ronny
 */
public class CupToPintProblem extends ProblemHandler{

	/**
	 * Creates the sample problem.
	 */
	public CupToPintProblem() {
		super(3);
	}

	@Override
	public void onStart(Pane layout) {
		switch(stage)
		{
		case 1:
			layout.getChildren().add(new Text("In this problem we will be converting cups to pint"));
			layout.getChildren().add(new Text("Solve the following. How many pints are in 8 cups?"));
			break;
		case 2:
			layout.getChildren().add(new Text("There are 2 cups for each pints 2 cups = 1 pint"));
			layout.getChildren().add(new Text("8 "));
			layout.getChildren().add(new Text("_  = 4 pints"));
			layout.getChildren().add(new Text("2 "));
			break;
		case 3:
			layout.getChildren().add(new Text("Answer: There are 4 pints in 8 cups."));
			break;
		}
	}

}
