package com.example.xyz.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.xyz.model.Anagram;
import com.example.xyz.service.IAnagramService;


/**
 * The class AnagramController where we find the REST methods.
 */
@RestController
//@RequestMapping("api")
public class AnagramController {


  @Autowired
  private IAnagramService anagramService;


	@PostMapping("/anagram")
	public ResponseEntity<?> getAnagramforStringPhrase(@RequestBody Anagram request) throws FileNotFoundException, Exception {
		anagramService.getAnagrams(request);				 
		 return new ResponseEntity<Anagram>(request, HttpStatus.OK);
	}
	
	
   
	
	/*
	 * @CrossOrigin(origins = "http://localhost:4200")
	 * 
	 * @RequestMapping(value = "anagram", method = RequestMethod.POST, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public @ResponseBody Map<String, Object>
	 * getDiagramsUsingDictionary(
	 * 
	 * @RequestParam(name = "phrase", required = true) String phrase) throws
	 * Exception {
	 * 
	 * // Search the anagrams String anagrams = anagramService.getAnagrams(phrase);
	 * 
	 * 
	 * Map<String, Object> result = new HashMap<String, Object>();
	 * result.put("word", phrase); result.put("anagrams", anagrams);
	 * 
	 * return result; }
	 */
}
