package services;

import piglatin.PigLatin;

public class PigLatinService {
	
	
	private PigLatin pigLatin;
	
	public PigLatinService(PigLatin pigLatin) {
		this.pigLatin = pigLatin;
	}
	
	
	public String encodeSentence(String sentence) {
		
		//converting the sentence into an array of words
		String[] words = sentence.split(" ");
		
		StringBuilder sb = new StringBuilder();
		
		//for each word, pass the word to the encode method in the PigLatin class
		for(String word : words) {
			String pigLatinWord = pigLatin.encode(word);
			sb.append(" ");
			sb.append(pigLatinWord);
			
		}
		
		//deleting space at beginning of sentence then converting to string
		return sb.deleteCharAt(0).toString();
	}
	
}
