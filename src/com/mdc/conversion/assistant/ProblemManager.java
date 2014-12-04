package com.mdc.conversion.assistant;

import javafx.scene.layout.Pane;

/**
 * The problem manager handles all the sample problems on how to solve certain conversion formulas.
 * @author Tony Erazo
 *
 */
public class ProblemManager {
	
	/**
	 * Current handler binded to the manager.
	 */
	private ProblemHandler currentHandler;
	
	/**
	 * Submits a problem to be handled by the manager.
	 * @param problem the handler.
	 * @param layout the layout of the application.
	 */
	public void submit(ProblemHandler problem, Pane layout)
	{
		this.currentHandler = problem;
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
