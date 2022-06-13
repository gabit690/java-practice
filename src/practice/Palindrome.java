package practice;
import javax.swing.JOptionPane;

public class Palindrome {

  private static boolean isPalindrome(String phrase) {
	
	String phraseFormated = phrase.replaceAll("[^a-zA-Z]+", "");

	StringBuilder reversePhrase = (new StringBuilder(phraseFormated)).reverse();
	
	return reversePhrase.toString().equalsIgnoreCase(phraseFormated);
  }
	
  public static void main(String[] args) {
	
	String phrase = JOptionPane.showInputDialog("Write your phrase: ");
	
	String messageResult = "It's ".concat(isPalindrome(phrase) ? "": "NOT ")
								  .concat("a palindrome.");
	
	JOptionPane.showMessageDialog(null, phrase.concat("\n\n" + messageResult), "Comparison result", JOptionPane.INFORMATION_MESSAGE);
  }
	
}
