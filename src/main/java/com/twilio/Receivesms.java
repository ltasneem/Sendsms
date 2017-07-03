package com.twilio;

import static spark.Spark.post;

import static spark.Spark.*;
import com.twilio.twiml.Body;
import com.twilio.twiml.Message;
import com.twilio.twiml.MessagingResponse;

/*
Created By
Lubaba Nuzhat Tasneem
*/
public class Receivesms {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//https://29ccde89.ngork.io/receive-sms
		get("/", (req, res) -> "Hello, World");
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
			Message sms = new Message.Builder()
					.body(new Body(final_s))
					.build();
			MessagingResponse twiml = new MessagingResponse.Builder()
					.message(sms)
					.build();

			System.out.println(s);

			
			return twiml.toXml();


		});

	}

}
