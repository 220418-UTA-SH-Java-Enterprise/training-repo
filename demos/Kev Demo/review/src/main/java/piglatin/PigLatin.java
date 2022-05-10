package piglatin;

public class PigLatin {
	/*
	 * Kevin
	 * 
	 * evinKay
	 * 
	 * elloHay imay evinKay
	 * 
	 * 
	 * KevinK
	 * evinK
	 * evinKay
	 */
	
	public String encode(String word) {
		
		StringBuilder sb = new StringBuilder(word);
		sb.append(sb.charAt(0)); // KevinK
		sb.deleteCharAt(0); //evinK
		sb.append("ay");
		
		return sb.toString();
	}
}
