package com.mdc.conversion.assistant.impl;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import com.mdc.conversion.assistant.ProblemHandler;

/**
 * Sample of a time conversion problem being solved with our problem assistant
 * system.
 * 
 * @author Tony Erazo
 * @author Ronny
 */
public class TimeConversionProblem extends ProblemHandler {

	/**
	 * Creates the sample problem.
	 */
	public TimeConversionProblem() {
		super(3);
	}

	@Override
	public void onStart(Pane layout) {
		switch (stage) {
		case 1:
			layout.getChildren().add(new Text("We will be solving the following"));
			layout.getChildren().add(new Text("How many seconds are in one minute?"));
			break;
		case 2:
			layout.getChildren().add(new Text("There are 60 seconds in 1 minute"));
			layout.getChildren().add(new Text("60 x 1 = 60"));
			break;
		case 3:
			layout.getChildren().add(new Text("The answer is 60 minutes."));
			break;
		}
	}

}
