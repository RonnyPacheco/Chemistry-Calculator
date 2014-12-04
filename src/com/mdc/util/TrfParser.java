package com.mdc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.mdc.conversion.assistant.ProblemHandler;

/**
 * The TrfParser is designed to read .trf files which load classes into our application.
 * @author Tony Erazo
 */
public class TrfParser {

	/**
	 * Path of our handlers.
	 */
	private File handlerPath = new File("./data/problemhandlers.trf");

	/**
	 * The string modifier.
	 */
	private StringModifier stringModifier = new StringModifier();

	/**
	 * File reader.
	 */
	private BufferedReader reader;
	
	private Map<String, ProblemHandler> classes = new HashMap<>();
	
	/**
	 * Contains the names of the handlers.
	 */
	private String[] handlerNames;

	public TrfParser() {
		try {
			reader = new BufferedReader(new FileReader(handlerPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a TrfParser with the specified path
	 * @param handlerPath specified file path.
	 */
	public TrfParser(File handlerPath) {
		try {
			reader = new BufferedReader(new FileReader(handlerPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Parses all the problem handlers and binds them to the handler listings.
	 * @throws IOException
	 */
	public void loadHandlers() throws IOException{
		for (String line = reader.readLine(); line != null; line = reader
				.readLine()) {
			if (line.contains("#")) {
				String thePackage = stringModifier.removeSingleChar(line, line.indexOf("#"));
				String name = stringModifier.substringFirstCapitalChar(thePackage);
				try {
					Class<?> handlerClass = Class.forName(thePackage);
					System.out.println(thePackage);
					Object handlerInstance = handlerClass.newInstance();
					classes.put(name, (ProblemHandler) handlerInstance);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		handlerNames = new String[classes.size()];
		
		int index = 0;
		for(String name : classes.keySet())
		{
			handlerNames[index] = name;
			index++;
		}
	}
	
	/**
	 * Gets the handlers of the application.
	 * @return handlers {@link classes}.
	 */
	public Map<String, ProblemHandler> getHandlers()
	{
		return classes;
	}
	
	/**
	 * Gets a string array of the handler names.
	 * @return handlerNames {@link handlerNames}
	 */
	public String[] getHandlerNames()
	{
		return handlerNames;
	}
	
	
}
