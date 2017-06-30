package com.twilio;

import static spark.Spark.post;

import static spark.Spark.*;
import com.twilio.twiml.Body;
import com.twilio.twiml.Message;
import com.twilio.twiml.MessagingResponse;

public class Receivesms {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//https://29ccde89.ngork.io/receive-sms
		get("/", (req, res) -> "Hello, World");
		post("/receive-sms", (req,res) -> {
			Message sms = new Message.Builder()
					.body(new Body("Is there any way you can come here?"))
					.build();
			MessagingResponse twiml = new MessagingResponse.Builder()
					.message(sms)
					.build();
			
			return twiml.toXml();
			
			
		});

	}

}
