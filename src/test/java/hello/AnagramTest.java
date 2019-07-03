package hello;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramTest {
	   public static void main(String[] args) throws FileNotFoundException {
	        Scanner s = new Scanner(new File("words_alpha.txt"));

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
	        Scanner input = new Scanner(System.in);
	        String str = input.next();
	        char[] key = str.toCharArray();
	        Arrays.sort(key);
	        str = new String(key).toLowerCase();
	        if (!map.containsKey(str)) {
	            System.out.print("word not found");
	        } else if (map.get(str).size() != 1) {
	            for (String p : map.get(str)) {
	                System.out.print(p + " ");
	            }
	        } else {
	            System.out.print("No anagrams found");
	        }
	        s.close();
	        input.close();
	    }
	   
}
