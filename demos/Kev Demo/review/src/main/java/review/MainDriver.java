package review;

import java.util.*;
import models.User;
import piglatin.PigLatin;
import services.PigLatinService;

public class MainDriver {
	public static void main(String[] args) {
		
		
		/*
		 *	Wrapper classes are class equivalents to primitive data types
		 *
		 * Bitter (Boolean 1 bit)
		 * Black (Byte 1 byte == 8 bits)  00000011
		 * Coffee (Char 2 bytes)
		 * Sure (Short 2 bytes)
		 * Is (Integer 4 bytes )
		 * For (Float 4 bytes)
		 * Long (Long 8 bytes)
		 * Days (Double 8 bytes)
		 */
		
//		Byte b = 12;
//		
//		//autoboxing
//		//the conversion of the primitive data type to the wrapper class equivalent implicitly
//		Double d = 120.4; //autoboxing
//		
//		
//		//unboxing
//		//The conversion of the wrapper class to the primitive equivalent implicitly
//		double prim = d;
//		
//		
//		List<Double> doubles = new ArrayList<>();
//		
//		Queue<String> q = new LinkedList<>();
//		
//		
//		
//		List<String> list = new LinkedList<>();
//		list.add("Kevin");
//		list.add("Childs");
//		
//		list.remove(0);
//		
//		System.out.println(list.get(1));
//		
//		User user = new User("Kevin", "Childs");
		
		PigLatin pigLatin = new PigLatin();
//		
//		System.out.println(pigLatin.encode("Poonam"));
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter sentence: ");
		String word = sc.nextLine();
		
		PigLatinService pls = new PigLatinService(pigLatin);
		System.out.println(pls.encodeSentence(word));
	}
}
