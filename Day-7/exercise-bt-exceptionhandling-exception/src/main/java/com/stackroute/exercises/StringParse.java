package com.stackroute.exercises;


public class StringParse {
    //Write logic to find the character from the sentence at specified location
    public char characterLocator(String sentence, String location) {
    	if(!location.matches("-?\\d+")) {
    		throw new NumberFormatException("NumberFormatException");
    	}
    	
    	if(Integer.parseInt(location)>=sentence.length())
    	{
    		throw new StringIndexOutOfBoundsException("StringIndexOutOfBoundsException");
    	}
        return sentence.charAt(Integer.parseInt(location));
    }
}
