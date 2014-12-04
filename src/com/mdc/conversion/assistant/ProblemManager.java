package com.mdc.conversion.assistant;

import javafx.scene.layout.VBox;

public class ProblemManager {
	
	private boolean hadPreviousHandler;
	private ProblemHandler currentHandler;
	public void submit(ProblemHandler problemAssistant, VBox layout)
	{
		this.currentHandler = problemAssistant;
		hadPreviousHandler = true;
		currentHandler.onStart(layout);
	}
	
	public void next()
	{
		if(currentHandler != null)
			currentHandler.next();
	}
	
	public boolean hadPreviousHandler()
	{
		return hadPreviousHandler;
	}
}
