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
	private final int maxStages;
	
	/**
	 * Creates a problem assitant with a predefined amount of stages.
	 * @param maxStages
	 */
	public ProblemHandler(int maxStages)
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
	 * Flags if its possible to go to the next stage of the handler if it is it will go to the next stage.
	 */
	public boolean next()
	{
		if(stage < maxStages)
		{
			stage++;
			return true;
		}
		return false;
	}
	
	/**
	 * Resets the current stage of the handler
	 */
	public void reset()
	{
		this.stage = 1;
	}
}
