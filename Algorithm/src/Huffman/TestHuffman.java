package Huffman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestHuffman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Huffman huf = new Huffman();

		try {
			BufferedReader in = new BufferedReader(new FileReader("Huffman.txt"));
			String line = in.readLine();

			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ,;");
	
				
				while (parser.hasMoreTokens()) {
					String temp = parser.nextToken().toUpperCase();
					for(int i=0; i<temp.length(); i++){
						char word = temp.charAt(i);
						huf.add(word);
					}
				}

				line = in.readLine();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		huf.frequencyPrint();
		huf.insertQueue();
		huf.makeHuffman();
		huf.huffmanPrint();
		
		System.out.println("<<<<< Text Encoding >>>>>");
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("Huffman.txt"));
			String line = in.readLine();

			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ,;");
	
				
				while (parser.hasMoreTokens()) {
					String temp = parser.nextToken().toUpperCase();
					for(int i=0; i<temp.length(); i++){
						char word = temp.charAt(i);
						huf.find(word);;
					}
				}
				System.out.println();
				line = in.readLine();
			}
		} catch (IOException e) {
			System.out.println(e);
		}		
	}

}
