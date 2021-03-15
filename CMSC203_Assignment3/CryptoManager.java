/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: A class with methods that perform encryption and decryption of strings using Caesar Cipher and Bellaso Cipher
 * Due: 3/14/2021
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Jessica Bunting
*/

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		// Loop through characters in plainText (from charAt(0) to charAt(plainText.length())?
		boolean boundsStatus = true;
		for (int i = 0; i < plainText.length(); i++) {
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND)
				boundsStatus = false;
		}
		return boundsStatus;
		// For each char, if it is out of bounds (char < LOWER_BOUND || char > UPPER_BOUND, return false and break?
		// Else if all are in bounds, return true
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return encryptedText the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String encryptedText = "";
		// Loop through characters in plainText (from charAt(0) to charAt(plainText.length())
		for (int i = 0; i < plainText.length(); i++) {
			int wrapAround = (int)(plainText.charAt(i)) + key;
			while (wrapAround > UPPER_BOUND) {
				wrapAround -= RANGE;
			}
			encryptedText += (char) (wrapAround);
		}
		return encryptedText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String encryptedText = "";
		String keyStr = "";;
		// Extend key word (bellasoStr) to length of plainText string
		for (int y = 0, z = 0; y < plainText.length(); y++, z++) {
			if (z == bellasoStr.length()) {
				z = 0;
			}
			keyStr += bellasoStr.charAt(z);
		}
		for (int i = 0; i < plainText.length(); i++) {
			// Replace current character in plainText by itself offset by corresponding character in keyStr
			int wrapAround = plainText.charAt(i) + keyStr.charAt(i);
			while (wrapAround > UPPER_BOUND) {
				wrapAround -= RANGE;
			}
			encryptedText += (char) (wrapAround);
		}
		return encryptedText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decryptedText = "";		
		for (int i = 0; i < encryptedText.length(); i++) {
			int wrapAround = (int) (encryptedText.charAt(i)) - key;
			while (wrapAround < LOWER_BOUND) {
				wrapAround += RANGE;
			}
			decryptedText += (char) (wrapAround);
		}	
		return decryptedText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decryptedText = "";
		String keyStr = "";
		// Extend key word (bellasoStr) to length of encryptedText string	
		for (int j = 0, k = 0; j < encryptedText.length(); j++, k++) {
			if (k == bellasoStr.length()) {
				k = 0;
			}
			keyStr += bellasoStr.charAt(k);
		}
		for (int i = 0; i < encryptedText.length(); i++) {
			int wrapAround = encryptedText.charAt(i) - keyStr.charAt(i);
			while (wrapAround < LOWER_BOUND) {
				wrapAround += RANGE;
			}
			decryptedText += (char)(wrapAround);
		}	
		return decryptedText;
	}
}
