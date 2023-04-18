package wordTracker;

public class Occurrence {
	private String fileName;
	private int lineNumber;
	
	/**
	 * Construcor for a Occurrence Object
	 * @param fname the name of the file the word is located in 
	 * @param line the line number of the file the word appeared on 
	 */
	public Occurrence(String fname, int line) {
		this.fileName = fname;
		this.lineNumber = line;
	}

	/**
	 * Method to get the fileName
	 * @return the fileName the word if from 
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Mehtod to set the file name
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Method to get the line number of the work
	 * @return the lineNumber
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * Method to get the lineNumber
	 * @param lineNumber the lineNumber to set
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
}
