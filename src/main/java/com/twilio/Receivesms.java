package com.twilio;

import static spark.Spark.post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static spark.Spark.*;
import com.twilio.twiml.Body;
import com.twilio.twiml.Message;
import com.twilio.twiml.MessagingResponse;

import crunch.chatbot.*;
/*
Created By
Lubaba Nuzhat Tasneem
*/
public class Receivesms {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Twilio.init("","");
		//cant make chat bot here
		Chat_bot chat = new Chat_bot("");
		//Sendsms sms = new Sendsms();
		//sms.send("Hello Rachel");
	
		//https://29ccde89.ngork.io/receive-sms
	//	get("/", (req, res) -> "Hello, World");
		post("/receive-sms", (req,res) -> {
			/*Message sms = new Message.Builder()
					.body(new Body("Is there any way you can come here?"))
					.build();*/
			
			String s= req.body();
			String[] splitArray = s.split("&");
			int i=0;
			for(;i<splitArray.length;i++)
			{
				if(splitArray[i].contains("Body="))
					break;
			}
			String final_s= splitArray[i].replace("Body="," ");
			final_s = final_s.replace("+"," ");
			
			String response = chat.rachael_main(final_s);
			
			Message sms = new Message.Builder()
					.body(new Body(response))
					.build();
			MessagingResponse twiml = new MessagingResponse.Builder()
					.message(sms)
					.build();

			
			
			System.out.println(s);

			
			return twiml.toXml();


		});

	}
	
	
	

}
