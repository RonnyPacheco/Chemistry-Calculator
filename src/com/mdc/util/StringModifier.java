package com.mdc.util;

/**
 * This class provides utility methods to modifying a string.
 * 
 * @author Tony Erazo
 *
 */
public class StringModifier {

	/**
	 * Removes a single character from the string
	 * 
	 * @param string
	 *            String being modified.
	 * @param index
	 *            desired character index to be removed
	 * @return the string with the character removed.
	 */
	public String removeSingleChar(String string, int index) {
		StringBuilder builder = new StringBuilder();
		char[] charArray = string.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (i != index) {
				builder.append(charArray[i]);
			}
		}
		return builder.toString();
	}

	/**
	 * Substrings the string after the first capital character inclusive
	 * (Capital character)
	 * 
	 * @param string
	 *            String being modified.
	 * @return the substring with the first capital character.
	 */
	public String substringFirstCapitalChar(String string) {
		StringBuilder builder = new StringBuilder();
		char[] charArray = string.toCharArray();
		boolean foundCapital = false;
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isUpperCase(charArray[i])) {
				foundCapital = true;
			}
			if (foundCapital) {
				builder.append(charArray[i]);
			}
		}

		return builder.toString();
	}
}
