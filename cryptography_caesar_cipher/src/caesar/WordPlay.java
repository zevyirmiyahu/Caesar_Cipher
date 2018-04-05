package caesar;

/*
 * Class contains methods for changing vowels and other characters 
 * to asterisks and plus symbols.
 * 
 */

public class WordPlay {

	//Method checks whether ch is a vowel
	public boolean isVowel(char ch) {
		
		//Upper case
		if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
			return true;
		} //lower case
		else if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return true;
		}
		else return false;
	}
	
	//Replaces all vowels upper and lower case of a string with char ch
	public String replaceVowels(String phrase, char ch) {
		StringBuilder sb = new StringBuilder(phrase);
		
		for(int i = 0; i < sb.length(); i++) {
			
			if(isVowel(sb.charAt(i))) {
				sb.setCharAt(i, ch);
			}
		}
		return sb.toString();
	}
	
	/*
	 * Method returns a string with the char ch replaced by * if the location of that ch is even or
	 * a + if the location of ch is odd. 
	 */
	public String emphasize(String phrase, char ch) {
		StringBuilder sb = new StringBuilder(phrase);
		
		for(int i = 0; i < sb.length(); i++) {
			
			if(sb.charAt(i) == ch) {
				// i + 1 because index of string starts at 0
				if(i % 2 == 0) { 
					sb.setCharAt(i, '*');
				}
				else {
					sb.setCharAt(i, '+');
				}
			}
		}
		return sb.toString();
	}
}
