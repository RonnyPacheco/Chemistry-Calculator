package com.mdc.concurrent;

import java.util.logging.Logger;

/**
 * The engine class handles multi tasking in the application running several tasks simultaneously.
 * @author Tony Erazo
 *
 */
public class Engine implements Runnable{

	/**
	 * Logs events of this class {@link Engine}
	 */
	private static Logger logger = Logger.getLogger(Engine.class.getName());
	/**
	 * Flags of the engine is running.
	 */
	private boolean started = false;
	
	/**
	 * The thread of the engine.
	 */
	private Thread thread;
	
	/**
	 * Starts the engine.
	 * @see started
	 */
	public void start()
	{
		if(started)
			throw new IllegalStateException("The engine has already started");
		thread = new Thread(this);
		started = true;
		thread.start();
	}
	
	/**
	 * Stops the engine.
	 * @see started
	 */
	public void stop()
	{
		if(!started)
			throw new IllegalStateException("The is currently not active!");
		started = false;
	}
	
	@Override
	public void run() 
	{
		logger.info("Initializing engine...");
	}


}
