package com.mdc.conversion.assistant;

import javafx.scene.layout.VBox;

public class ProblemManager {
	
	private ProblemHandler currentHandler;
	public void submit(ProblemHandler problemAssistant, VBox layout)
	{
		this.currentHandler = problemAssistant;
		currentHandler.onStart(layout);
	}
	
	/**
	 * Flags if its possible to go to the next stage of the handler if it is it will go to the next stage.
	 */
	public boolean next()
	{
		if(currentHandler != null)
		{
			return currentHandler.next();
		}
		return false;
	}
	
	/**
	 * Gets the current handler assigned to the manager.
	 * @return handler.
	 */
	public ProblemHandler getCurrentHandler()
	{
		return currentHandler;
	}
}
