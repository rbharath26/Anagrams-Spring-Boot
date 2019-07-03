package com.example.xyz.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.xyz.model.Anagram;
import com.example.xyz.service.IAnagramService;
@Service

public class AnagramServiceImpl implements IAnagramService {

	@Override
	public String getAnagrams(String wordsStr) throws Exception {
		Scanner scanner = new Scanner(new File("words_alpha.txt"));
		String anagramString="";

        ArrayList<String> words = new ArrayList<String>();
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : words) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp).toLowerCase();
            if (map.get(key) != null) {
                map.get(key).add(str.toLowerCase());
            } else {
                ArrayList<String> anagramList = new ArrayList<>();
                anagramList.add(str);
                map.put(key, anagramList);
            }
        }
        
        String[] wordsArray = StringUtils.split(wordsStr," ");
       // List<String> wordsArr = Arrays.asList(wordsArray);
        List<String> wordsArr = new ArrayList<String>();         
        // adding elements of array to arrayList. 
        Collections.addAll(wordsArr, wordsArray); 
        for (String str : wordsArr) {
        	 char[] key = str.toCharArray();
             Arrays.sort(key);
             str = new String(key).toLowerCase();
             if (!map.containsKey(str)) {
                 throw new Exception("word not found");
             } 
             else {
                 for (String p : map.get(str)) {
                	 anagramString= anagramString+p + " ";
                	 break;
                 }
             } 
             /*else if (map.get(str).size() != 1) {
                 for (String p : map.get(str)) {
                	 anagramString= anagramString+p + " ";
                	 break;
                 }
             } else {
            	 throw new Exception("No anagrams found");
             }*/
        }
       // Scanner input = new Scanner(System.in);
       // String str = input.next();
       
        scanner.close();
       // input.close();
		
		return anagramString;
		
	   // String[] wordsArray = StringUtils.split(wordsString," ");
	    //ArrayList<String> words =(ArrayList<String>) Arrays.asList(wordsArray);
	   
	}
	
	@Override
	public void getAnagrams(Anagram anagramOject) throws Exception {
		String requestString =anagramOject.getPhrase();
		if(requestString==null || requestString.isEmpty() ) {
			anagramOject.setError("Phrase is null or empty");
			return;
		}
		if(!requestString.matches("^[a-zA-Z ]*$")){
			anagramOject.setError("Phrase is Only Alphabet");
			return;
		}
		if(requestString.length()>=1024) {
			anagramOject.setError("Phrase cannot be greater than 1024");
			return;		
		}
			
		
		Scanner s = new Scanner(new File("words_alpha.txt"));
		String anagramString="";

        ArrayList<String> words = new ArrayList<String>();
        while (s.hasNext()) {
            words.add(s.next());
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : words) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp).toLowerCase();
            if (map.get(key) != null) {
                map.get(key).add(str.toLowerCase());
            } else {
                ArrayList<String> anagramList = new ArrayList<>();
                anagramList.add(str);
                map.put(key, anagramList);
            }
        }
        
        String[] wordsArray = requestString.split(" ");
       // List<String> wordsArr = Arrays.asList(wordsArray);
        List<String> wordsArr = new ArrayList<String>();         
        // adding elements of array to arrayList. 
        Collections.addAll(wordsArr, wordsArray); 
        for (String str : wordsArr) {
        	 char[] key = str.toCharArray();
             Arrays.sort(key);
             str = new String(key).toLowerCase();
             if (!map.containsKey(str)) {
            	anagramOject.setError(" Some Phrase doesnt have anagrams ");
     			                                         
             } 
             else {
                 for (String p : map.get(str)) {
                	 anagramString= anagramString+p + " ";
                	 break;
                 }
             } 
             /*else if (map.get(str).size() != 1) {
                 for (String p : map.get(str)) {
                	 anagramString= anagramString+p + " ";
                	 break;
                 }
             } else {
            	 throw new Exception("No anagrams found");
             }*/
        }

       
        s.close();
       // input.close();
		
        anagramOject.setAnagram(anagramString);
	   
	}
	

}
