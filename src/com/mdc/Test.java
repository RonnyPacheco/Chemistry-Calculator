package com.mdc;

import java.io.IOException;

import com.mdc.util.TrfParser;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		TrfParser trfParser = new TrfParser();
		
		try {
			trfParser.loadHandlers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
