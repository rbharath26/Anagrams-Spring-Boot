package com.example.xyz.service;

import java.io.FileNotFoundException;

import com.example.xyz.model.Anagram;

public interface IAnagramService {

	void getAnagrams(Anagram anagram ) throws FileNotFoundException, Exception;

	String getAnagrams(String wordsStr) throws Exception;

}
