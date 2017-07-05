package crunch.chatbot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;



/*
 * Eliza Chat Bot Implementation with 'Sentiments'
 * 
 * Srikant Kumar Kalaputapu
 * Taimur Sohrab
 * Toma Tadros
 * Lubaba Nuzhat Tasneem
 *  
 * June 28th, 2017
 */
public class Chat_bot {
	
	Therapist rachael = new Therapist();
	
	ArrayList<String> log = new ArrayList<String>();
	
	Conversation cv = new Conversation();
	HashMap<String, ArrayList<String>> prevConvos = null;
	
	
	//constructor add phone number and name
	
	public Chat_bot(String phone) throws IOException{
		if (!(cv.create_patient_directory(phone))) {
			prevConvos = cv.load_sessions(phone);
		}
		
		
	}
/*
	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		Random rand = new Random();
		long startTime = System.currentTimeMillis();
		
		//get patient name
		System.out.println("Enter your name. I will see if I can pull up any old records for you.");
		String patient = keyboard.nextLine();
		
		
		//get old sessions or create new patient file
		Conversation cv = new Conversation();
		HashMap<String, ArrayList<String>> prevConvos = null;
		if (!(cv.create_patient_directory(patient))) {
			prevConvos = cv.load_sessions(patient);
		}
		
	
		Therapist rachael = new Therapist();
		String input = "";
		System.out.println("Welcome to your therapy session! You can call me Dr. Rachael. What would you like to talk about?");
		log.add("Welcome to your therapy session! You can call me Dr. Rachael. What would you like to talk about?");
		input = keyboard.nextLine().toLowerCase();
		log.add(input);
		int endSessionCount = 0;
		while (!input.equals("q") || endSessionCount < 4) {
			if (input.equals("q")){
				if (endSessionCount == 0){
					System.out.print("You want to leave? All right but before you go, tell me ");
				}
				else if (endSessionCount == 1){
					System.out.print("Why are you in such a rush? Listen, just tell me ");
				}
				else if (endSessionCount == 2){
					System.out.print("You want to leave that bad?  Can you just hold on for one second? I need you to tell me ");
				}
				else{
					System.out.println("Fine. Leave then.");
					break;
				}
				String question_response = rachael.question();
				System.out.println(question_response);
				log.add(question_response);
				endSessionCount++;
				input = keyboard.nextLine();
				log.add(input);
				input = input.toLowerCase();
				continue;
			}

			int responseDecision = rand.nextInt(100);
			if (responseDecision < 20) {
				//look back at old convo   * change to input 
				ArrayList<String> lookBack;
				if (prevConvos != null) {
					int randConvo = rand.nextInt(prevConvos.keySet().size() + 1);
					lookBack = (randConvo == prevConvos.keySet().size()) ? log : prevConvos.get("session" + randConvo);
				} else lookBack = log;
				int randStatementIndex = rand.nextInt(lookBack.size() / 2);
				String randStatement = lookBack.get(randStatementIndex * 2 + 1);
				while(randStatement.equals("q")){
					randStatementIndex = rand.nextInt(lookBack.size() / 2);
					randStatement = lookBack.get(randStatementIndex * 2 + 1);
				}
				String response = "Earlier you said " + randStatement + ". Tell me why.";
				System.out.println(response);
				log.add(response);
				
			} else if (responseDecision >= 20 && responseDecision < 40) {
				//sentiment
				int sentiment_response = rachael.sentiment(input);
				String response = "";
				if (sentiment_response > 0) {
					response = "You seem to be happy about that! Tell me more.";
				} else if (sentiment_response < 0) {
					response = "That clearly doesn't sit well with you. Please expound.";
				} else {
					response = "Why don't you feel happy or sad about that?";
				}
				System.out.println(response);
				log.add(response);

			} else if (responseDecision >= 40 && responseDecision < 60) {
				//question
				String question_response = rachael.question();
				System.out.println(question_response);
				log.add(question_response);

			} else if (responseDecision >= 60 && responseDecision < 80) {
				//qualify
				String response = rachael.qualify(input);
				System.out.println(response);
				log.add(response);

			} else {
				//hedge
				String hedge_response = rachael.hedge();
				System.out.println(hedge_response);
				log.add(hedge_response);
			}

			input = keyboard.nextLine();
			log.add(input);
			input = input.toLowerCase();
		}
		long endTime = System.currentTimeMillis();
		long sessionTime = endTime - startTime;
		double cost = (sessionTime / 60000.0) * 10;
		cv.create_session(patient, log);
		System.out.printf("You owe me $%.02f for this session. Thanks for your time!\n", cost);
		
	}
	*/
	public String rachael_main(String input) throws IOException {
		Random rand = new Random();
		long startTime = System.currentTimeMillis();
		String output = "";
		Conversation cv = new Conversation();
		
		
		int endSessionCount = 0;
		if (input.equals("q")){
			if (endSessionCount == 0){
				output = "You want to leave? All right but before you go, tell me ";
			}
			else if (endSessionCount == 1){
				output = "Why are you in such a rush? Listen, just tell me ";
			}
			else if (endSessionCount == 2){
				output = "You want to leave that bad?  Can you just hold on for one second? I need you to tell me ";
			}
			else{
				output = "Fine. Leave then.";
			}
			
			String question_response = rachael.question();
		//	System.out.println(question_response);
			output += question_response;
			log.add(question_response);
			endSessionCount++;
			//input = keyboard.nextLine();
			log.add(input);
			
			input = input.toLowerCase();
			return output;
		}

		int responseDecision = rand.nextInt(100);
		if (responseDecision < 20) {
			//look back at old convo   * change to input 
			ArrayList<String> lookBack;
			if (prevConvos != null) {
				int randConvo = rand.nextInt(prevConvos.keySet().size() + 1);
				lookBack = (randConvo == prevConvos.keySet().size()) ? log : prevConvos.get("session" + randConvo);
			} else lookBack = log;
			int randStatementIndex = rand.nextInt(lookBack.size() / 2);
			String randStatement = lookBack.get(randStatementIndex * 2 + 1);
			while(randStatement.equals("q")){
				randStatementIndex = rand.nextInt(lookBack.size() / 2);
				randStatement = lookBack.get(randStatementIndex * 2 + 1);
			}
			String response = "Earlier you said " + randStatement + ". Tell me why.";
			//System.out.println(response);
			log.add(response);
			output = response;
			
			
			
		} else if (responseDecision >= 20 && responseDecision < 40) {
			//sentiment
			int sentiment_response = rachael.sentiment(input);
			String response = "";
			if (sentiment_response > 0) {
				response = "You seem to be happy about that! Tell me more.";
			} else if (sentiment_response < 0) {
				response = "That clearly doesn't sit well with you. Please expound.";
			} else {
				response = "Why don't you feel happy or sad about that?";
			}
		//	System.out.println(response);
			log.add(response);
			output = response;

		} else if (responseDecision >= 40 && responseDecision < 60) {
			//question
			String question_response = rachael.question();
			//System.out.println(question_response);
			log.add(question_response);	
			output = question_response;


		} else if (responseDecision >= 60 && responseDecision < 80) {
			//qualify
			String response = rachael.qualify(input);
		//	System.out.println(response);
			log.add(response);	
			output = response;


		} else {
			//hedge
			String hedge_response = rachael.hedge();
			//System.out.println(hedge_response);
			log.add(hedge_response);	
			output = hedge_response;

		}
		
		
		
		return output;
		
		
		
//		long endTime = System.currentTimeMillis();
//		long sessionTime = endTime - startTime;
//		double cost = (sessionTime / 60000.0) * 10;
//	//	cv.create_session(patient, log);
//		//System.out.printf("You owe me $%.02f for this session. Thanks for your time!\n", cost);
//		
		
	}

}
