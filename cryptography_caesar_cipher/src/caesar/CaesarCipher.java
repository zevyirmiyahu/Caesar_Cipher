package caesar;

import edu.duke.*;

/*
 * This program was made following the given criteria of a Coursera assignment from Duke University.
 * It contains the class to encrypt a message of the users choosing using two methods. Both methods 
 * employ a Caesar cipher to encrypt a message. One encryption method encrypts using only one key. 
 * The other method contained in the class encrypts using two keys. The class WordPlay swaps out 
 * vowels for asterisk and plus symbols and user specified characters.
 * 
 * @Author: Zev Yirmiyahu
 * @Since: 05/04/2018 
 */

public class CaesarCipher {
	
	//input message to encrypt using a key (shift in alphabet)
	public String encrypt(String input, int key) {
		
		StringBuilder encrypted = new StringBuilder(input); 
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
					     
		// New string of the alphabet with appropriate shift
		String shift = alphabet.substring(key, alphabet.length()) + alphabet.substring(0, key);
		
		for(int i = 0; i < encrypted.length(); i++) {
			
			char ch = input.charAt(i);
			int index = alphabet.indexOf(Character.toUpperCase(ch)); //makes upper case to check index in alphabet
			
			//character is in alphabet
			if(index != -1 && Character.isUpperCase(ch)) {
				encrypted.setCharAt(i, shift.charAt(index));
			}
			else if(index != -1 && Character.isLowerCase(ch)) { //if lower switches shift alphabet char to lower
				encrypted.setCharAt(i, Character.toLowerCase(shift.charAt(index)));
			}
		}
		return encrypted.toString();
	}
	
	/*
	 * Method encrypts using a caesar cipher with two keys, alternating
	 * the encryption between the two keys.
	 */
	public String encryptTwoKeys(String input, int key1, int key2) {
		
		StringBuilder encryptWithTwoKeys = new StringBuilder(); //Message to be altered
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		//Shift using key1
		String shift1 = alphabet.substring(key1, alphabet.length()) + alphabet.substring(0, key1);
		//Shift using key2
		String shift2 = alphabet.substring(key2, alphabet.length()) + alphabet.substring(0, key2);
		
		String encrypt1 = encrypt(input, key1);
		String encrypt2 = encrypt(input, key2);
		
	
		for(int i = 0; i < input.length(); i++) {
			if(i % 2 == 0) {
				encryptWithTwoKeys.append(encrypt1.charAt(i));
			}
			else {
				encryptWithTwoKeys.append(encrypt2.charAt(i));
			}
		}
		return encryptWithTwoKeys.toString();
	}
	
	/*
	 * Method opens file directory and allows user to choose desired text file to encrypt with the
	 * specified key defined in the method below.
	 */
	public void openFile() {
		
		int key = 23;
		int key1 = 23;
		int key2 = 17;
		
		FileResource fr = new FileResource();
		
		String message = fr.asString();
		String encrypted = encrypt(message, key);
		String decrypted = encrypt(encrypted, 26 - key);
		
		String twoKeyEncrypted = encryptTwoKeys(message, key1, key2);
		
		System.out.println("The encrypted message: \n" + encrypted);
		System.out.println("The decrypted mesage: \n" + decrypted);
		System.out.println("Original message: \n" + message +	 "\n\n The key used to encrypt: " + key);
		System.out.println();
		System.out.println(twoKeyEncrypted);

	}
	

	public static void main(String args[]) {

		CaesarCipher cc = new CaesarCipher();
		cc.openFile();
	}
}
