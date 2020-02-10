/*
 * A word is a ‘pyramid’ word if you can arrange the letters in increasing 
 * frequency, starting with 1 and continuing without gaps and without 
 * duplicates.
		   Examples:
		   banana is a pyramid word because you have 1 'b', 2 'n's, and 3 'a's.
		   bandana is not a pyramid word because you have 1 'b' and 1 'd'.

 */
package com.internship.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CheckPyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System. in);
		CheckPyramid check = new CheckPyramid();
		System.out.println("Enter a String to check whether is pyramid or not: ");
		String word = sc.nextLine();
		
		boolean isPyramid = check.isPyramid(word);
		System.out.println(isPyramid);
	}
	
	private static boolean isPyramid(String word) {
		Map<Character, Integer> freqMap  = new TreeMap<Character, Integer>(); 
		int count=0;
		// Converting given string to char array 
		char[] wordArray = word.toCharArray(); 
		
		// checking each char of strArray 
		for (char c : wordArray) { 
			if (freqMap.containsKey(c)) { 	
				// If char is present in freqMap, incrementing it's count by 1 
				freqMap.put(c, freqMap.get(c) + 1); 
			} 
			else { 	
				// If char is not present in freqMap, putting this char to freqMap with 1 as it's value 
				freqMap.put(c, 1); 
			} 
		} 
		
		freqMap = freqMap.entrySet().stream()
				   .sorted(Entry.comparingByValue())
				   .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));
		
		for (Integer value : freqMap.values()) {		
			count = value;
			break;
		}
		
		for (Integer value : freqMap.values()) {			
			if(count != value)
			{
				return false;
			}
			else
			{
				count++;
			}
		}
		// TODO Auto-generated method stub
		return true;
	}
}
