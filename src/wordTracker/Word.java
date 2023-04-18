package wordTracker;

import java.util.ArrayList;

public class Word implements Comparable {

	private String word;
	private ArrayList<Occurrence> whereItShowedUp;
	
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
	
	
	public int compareTo(Word theWord) {
		return this.word.compareTo(theWord.word);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
