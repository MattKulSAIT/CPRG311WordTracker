package wordTracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import exceptions.TreeException;
import referenceBasedTreeImplementation.BSTree;
import referenceBasedTreeImplementation.BSTree.Iterator;
import referenceBasedTreeImplementation.BSTreeNode;

public class WordCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Storing and Serializatino to do at a latter date 
		
		Scanner scanner = null;
		File file = null;
		String fileName ="res/MattTest.txt";
		BSTree BST = new BSTree();
		
		try {
			file = new File("res/MattTest.txt");
			scanner = new Scanner(file);
		 

			while(scanner.hasNext()) {
				String aLine = scanner.nextLine();
			
				String [] listOfLine = aLine.split("\\s+");
				int lineNumber = 1;
				for(String word: listOfLine) {
					
					Word aWord = new Word(word,fileName,lineNumber);
					
					//BSTreeNode aNode = new BSTreeNode(aWord);
					
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
		
		System.out.println("Stuff");
		Iterator i = BST.inorderIterator();
		
		while(i.hasNext()) {
			System.out.println(((Word) i.next().getHolding()).getWord());
		}
	}

}
