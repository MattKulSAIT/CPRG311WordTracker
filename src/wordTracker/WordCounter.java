package wordTracker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.TreeException;
import referenceBasedTreeImplementation.BSTree;
import referenceBasedTreeImplementation.BSTree.Iterator;
import referenceBasedTreeImplementation.BSTreeNode;

/**
 * WordCounter class will take in a file from the command line and add the words to a binary tree
 *@author Alex, Matthew, Quintin, Miguel
 *
 */
public class WordCounter {

	/**
	 * WordCounter Run, this method will get given a text file and get all the words, Words
	 * will be stored in a binary tree
	 * @param args the array of strings that is not used 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Storing and Serializatino to do at a latter date 
		//Alter the code is ignore if the thing = "" becuase its catching empty spaces
		
		Scanner scanner = null;
		File file = new File(args[0]);;
		String fileName =args[0];
		BSTree BST = getExistingTree();
		String printType = args[1];
		boolean saveToOutputFile = false;
		File outputFile = null;
		if(args.length > 2) {
			outputFile = new File(args[3]);
			saveToOutputFile = true;
		}
		
		try {
			scanner = new Scanner(file);
			int lineNumber = 1;

			while(scanner.hasNext()) {
				String aLine = scanner.nextLine();
			
				//Need to inclued the sybmoles too
				String [] listOfLine = aLine.split("[\\s\\p{Punct}]+");
				
				for(String word: listOfLine) {
					if(!word.equals("")) {
						Word aWord = new Word(word,fileName,lineNumber);
						
						if(BST.size() < 1) {
							BST.add(aWord);
						}
						else {
							if(BST.contains(aWord)) {
								BSTreeNode someNode = BST.search(aWord);
								Word anotherOccurence = (Word) someNode.getHolding();
								anotherOccurence.addInstance(fileName, lineNumber);
							}
							else {
								BST.add(aWord);
							}
						}
					}
				}
				lineNumber++;
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("This file is missing");
			e.printStackTrace();
		} catch (TreeException e) {
			System.out.println("The tree is empy ");
			e.printStackTrace();
		}
		
		
		Iterator i = BST.inorderIterator();
		if(saveToOutputFile == false) {
			if(printType.equals("-pf")) {
				pfPrint(i);
			}
			else if(printType.equals("-pl")) {
				plPrint(i);
			}
			else if(printType.equals("-po")) {
				poPrint(i);
			}
			else {
				System.out.println("Enter in (-pf) (-pl) (-po) for output");
			}
		}
		//This is when the user wanted the printout to appear in the output file
		else {
			if(printType.equals("-pf")) {
				pfOutputFile(i,outputFile);
			}
			else if(printType.equals("-pl")) {
				plOutputFile(i,outputFile);
			}
			else if(printType.equals("-po")) {
				poOutputFile(i,outputFile);
			}
			else {
				System.out.println("Enter in (-pf) (-pl) (-po) for output");
			}
		}
		
		//Serializaion of the BSTree contents 
		Iterator iToBeSerilaized = BST.preorderIterator();
		serializeTree(iToBeSerilaized);
	}

	/**
	 * Private method to check of the existing binary tree
	 * If found it will be recreated and gaven to the main program
	 * if not a new empty one will be provided 
	 * @return
	 */
	private static BSTree getExistingTree() {
		File file = new File("res/repository.ser");
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			Iterator i = (Iterator) ois.readObject();
			BSTree BST = new BSTree();
			while(i.hasNext()) {
				BST.add((Word)i.next().getHolding());
			}
			return BST;
		}
		catch(FileNotFoundException e) {
			//The tree dose not exist so a new one is returned
			return new BSTree();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Serialize The contents of the binary tree to res/repository.ser
	 * @param i an iterator of the binary tree in order to be serialized  
	 */
	private static void serializeTree(Iterator i) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("res/repository.ser"));
			 out.writeObject(i);
			 out.close();
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	/**
	 * Private method to print the list in alphabetical order with the files they came from 
	 * @param i an iterator of the binary tree in alphabetic order 
	 */
	private static void pfPrint(Iterator i) {
		while(i.hasNext()){
			Word currentWord = ((Word) i.next().getHolding());
			System.out.print(currentWord.getWord() + " --> ");
			ArrayList<Occurrence> showedUp = currentWord.getWhereItShowedUp();
			for(Occurrence occurence: showedUp) {
				System.out.print("("+occurence.getFileName() +") ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Private method to print the list in alphabetical order with the files they came from and the line numbers 
	 * @param i an iterator of the binary tree in alphabetic order 
	 */
	private static void plPrint(Iterator i) {
		while(i.hasNext()){
			Word currentWord = ((Word) i.next().getHolding());
			System.out.print(currentWord.getWord() + " --> ");
			ArrayList<Occurrence> showedUp = currentWord.getWhereItShowedUp();
			for(Occurrence occurence: showedUp) {
				System.out.print("("+occurence.getFileName() +" Line Number:"+occurence.getLineNumber()+") " );
			}
			System.out.println();
		}
	}
	
	/**
	 * Private method to print the list in alphabetical order with the files they came from and the line numbers along
	 * with the frequency of the words apprences 
	 * @param i an iterator of the binary tree in alphabetic order 
	 */
	private static void poPrint(Iterator i) {
		while(i.hasNext()){;
			Word currentWord = ((Word) i.next().getHolding());
			System.out.print(currentWord.getWord() + " --> ");
			ArrayList<Occurrence> showedUp = currentWord.getWhereItShowedUp();
			for(Occurrence occurence: showedUp) {
				System.out.print("("+occurence.getFileName() +" Line Number:"+occurence.getLineNumber()+") " );
			}
			System.out.print("This word showed up: "+showedUp.size());
			System.out.println();
		}
	}
	
	
	/**
	 * Private method to print the list in alphabetical order with the files they came from s
	 * This method outputs the on the file sepcified 
	 * @param i an iterator of the binary tree in alphabetic order 
	 */
	private static void pfOutputFile(Iterator i, File f) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(f);

			while(i.hasNext()){
				Word currentWord = ((Word) i.next().getHolding());
				String theLine = currentWord.getWord() + " --> ";
				ArrayList<Occurrence> showedUp = currentWord.getWhereItShowedUp();
				for(Occurrence occurence: showedUp) {
					theLine = theLine+"("+occurence.getFileName() +") ";
				}


				writer.println(theLine);
				writer.println();
			}
			writer.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Private method to print the list in alphabetical order with the files they came from and the line numbers 
	 * This method outputs the on the file sepcified 
	 * @param i an iterator of the binary tree in alphabetic order 
	 */
	private static void plOutputFile(Iterator i, File f) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(f);

			while(i.hasNext()){
				Word currentWord = ((Word) i.next().getHolding());
				String theLine = currentWord.getWord() + " --> ";
				ArrayList<Occurrence> showedUp = currentWord.getWhereItShowedUp();
				for(Occurrence occurence: showedUp) {
					theLine = theLine+"("+occurence.getFileName() +" Line Number:"+occurence.getLineNumber()+") ";
				}


				writer.println(theLine);
				writer.println();
			}
			writer.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Private method to print the list in alphabetical order with the files they came from and the line numbers along
	 * with the frequency of the words apprences 
	 * This method outputs the on the file sepcified 
	 * @param i an iterator of the binary tree in alphabetic order 
	 */
	private static void poOutputFile(Iterator i, File f) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(f);

			while(i.hasNext()){
				Word currentWord = ((Word) i.next().getHolding());
				String theLine = currentWord.getWord() + " --> ";
				ArrayList<Occurrence> showedUp = currentWord.getWhereItShowedUp();
				for(Occurrence occurence: showedUp) {
					theLine = theLine+"("+occurence.getFileName() +" Line Number:"+occurence.getLineNumber()+") ";
				}
				theLine = theLine +"This word showed up: "+showedUp.size();

				writer.println(theLine);
				writer.println();
			}
			writer.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
