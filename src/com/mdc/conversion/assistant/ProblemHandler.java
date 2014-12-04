package com.mdc.conversion.assistant;

import javafx.scene.layout.Pane;

public abstract class ProblemHandler {

	/**
	 * The stage of the current problem by default the stage always starts at one.
	 */
	protected int stage = 1;
	
	/**
	 * The maximum amount of stages..
	 */
	private int maxStages;
	
	/**
	 * Creates a problem assitant with a predefined amount of stages.
	 * @param maxStages
	 */
	protected ProblemHandler(int maxStages)
	{
		if(maxStages < 1)
			throw new IllegalStateException("The final stage must be greater than 1");
		
		this.maxStages = maxStages;
	}
	
	/**
	 * Handles the initialization of the problem assistant when solving the problem.
	 */
	public abstract void onStart(Pane layout);
	
	/**
	 * Gets the current stage of the problem being solved.
	 * @return {@code stage}
	 */
	public int getStage()
	{
		return stage;
	}
	
	/**
	 * Gets the maximum stage id.
	 * @return maximum stage.
	 */
	public int getFinalStage()
	{
		return maxStages;
	}
	
	/**
	 * Goes to the next stage of the handler.
	 */
	public void next()
	{
		if(stage < maxStages)
		{
			stage++;
		}
	}
}
