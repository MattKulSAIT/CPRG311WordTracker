package wordTracker;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class to make a Word object that hold a word, and the ocurrences of it 
 * @author Alex, Matthew, Quintin, Miguel
 *
 */
public class Word implements Comparable<Word>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String word;
	private ArrayList<Occurrence> whereItShowedUp = new ArrayList();
	
	/**
	 * Constructor to make a word Object 
	 * @param word The word read from the file
	 * @param fileName The name of the file that we are reading from 
	 * @param lineNum The line number of the file 
	 */
	public Word(String word, String fileName, int lineNum) {
		this.word = word;
		Occurrence o = new Occurrence(fileName, lineNum);
		whereItShowedUp.add(o);
	}
	
	/**
	 * Adds an instrance to the arrayList of an object 
	 * @param fileName name of the file read from 
	 * @param lineNum The Line number that the word appread at                 
	 */
	public void addInstance(String fileName, int lineNum) {
		Occurrence o = new Occurrence(fileName, lineNum);
		whereItShowedUp.add(o);
	}
	
	/**
	 * compareTo method to compare to Word object using the word field 
	 */
	@Override
	public int compareTo(Word theWord) {
		return this.word.compareTo(theWord.word);
	}
	
	/**
	 * Geter method for the word feild in a Word object 
	 * @return the word stored in the Word object 
	 */
	public String getWord() {
		return this.word;
	}

	/**
	 * Method to get the ArrayList the holds all the times the word was read in the files
	 * @return the whereItShowedUp
	 */
	public ArrayList<Occurrence> getWhereItShowedUp() {
		return whereItShowedUp;
	}
	
}


