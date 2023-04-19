package wordTracker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		File file = null;
		String fileName ="res/textfile.txt";
		BSTree BST = getExistingTree();
		
		try {
			file = new File("res/textfile.txt");
			scanner = new Scanner(file);
			int lineNumber = 1;

			while(scanner.hasNext()) {
				String aLine = scanner.nextLine();
			
				//Need to inclued the sybmoles too
				String [] listOfLine = aLine.split("[\\s\\p{Punct}]+");
				
				for(String word: listOfLine) {
					
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
		
		//System.out.println("Stuff");
		Iterator i = BST.inorderIterator();
		pfPrint(i);
		
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
}
