package crunch.chatbot;
/*
 * Qualifier Handler for Chat Bot Implementation.
 * Srikant Kumar Kalaputapu
 * June 28th, 2017
 * 
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Qualifier {
	
	//Set of qualifier statements
	private Set<String> qualifierSet = new HashSet<String>();
	
	/**
	 * Creates default set of qualifiers
	 */
	public Qualifier(){
		qualifierSet.add("Why do you say that ");
		qualifierSet.add("You seem to think that ");
		qualifierSet.add("So, you are concerned that ");
		qualifierSet.add("Do you really mean that ");
		qualifierSet.add("Other people believe that ");
		qualifierSet.add("Why would you believe that ");
		qualifierSet.add("You are completely wrong when you say that ");
		qualifierSet.add("Do you want to talk about why that ");
		qualifierSet.add("Did you really just say that ");
		qualifierSet.add("What right do you have to suggest that ");
		qualifierSet.add("Don't you dare say that ");
		qualifierSet.add("I didn't know that ");
		qualifierSet.add("How likely is it that ");
		qualifierSet.add("Some of us in the industry also believe that ");
		qualifierSet.add("I guess I can't argue that ");
		qualifierSet.add("How does it make you feel that ");
		qualifierSet.add("Ultimately, the world doesn't care that ");
		qualifierSet.add("Honestly, I really don't give a damn that ");
	
	}
	
	
	/**
	 * Create list of qualifiers from pre-existing set of qualifiers
	 * @param s - preexisting qualifier set
	 */
	public Qualifier(Set s){
		qualifierSet.addAll(s);
	}
	
	/**
	 * Add new qualifier statement to set of qualifiers
	 * @param statement - new qualifier to be added
	 */
	public void addQualifier(String statement){
		qualifierSet.add(statement);
	}
	
	/**
	 * Selects a random qualifier to use from the set
	 * @return random qualifier statement
	 */
	public String getRandomQualifier(){
		Random rand = new Random();
		int index = rand.nextInt(qualifierSet.size());
		Iterator<String> iter = qualifierSet.iterator();
		for (int i = 0; i < index; i++) {
		    iter.next();
		}
		return iter.next();
	}
	
	
	
}
