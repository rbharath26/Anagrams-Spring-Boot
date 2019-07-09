# Anagrams-Spring-Boot
# Anagram Service/Client

### Service
Using Spring Boot, Gradle, and your JVM language of choice, create a REST service that:
- Receives a payload of the following format, where `phrase` is a case-insensitive string of space separated words, made up of alpha-characters only (no numbers, punctuation or special characters):

  ```javascript
  // GET <service>:<port>/anagram
  {
    "phrase": "words demo"
  }
  ```

- replaces each word in the phrase with a random single word anagram for that word from the given dictionary - use words_alpha.txt (note: this can be the same word that was provided, it should be randomly selected from the list of words that are an anagram of the given word)

  ```javascript
  {
    "anagram": "sword mode"
  }
  ```

- Validates the request using the following rules, and returns an appropriate HTTP error response:
  - The request can not be empty/null
  - Content-Type must be application/json
  - Phrase can not be empty/null
  - Phrase must be < 1024 characters in length
  - Phrase should only contain alphabetical characters (no punctuation or special characters) and spaces

Configure Spring Boot to expose this service on port 3000.

Create a Dockerfile that bundles this service into a container
Spring Boot REST API for Anagrams 

http://localhost:3000/api/anagram

Request:
 {
    "phrase": "words demo" 
   
  }
  
  Response:
  {
    "phrase": "words demo",
    "anagram": "words moed ",
    "error": null
}


  
  
