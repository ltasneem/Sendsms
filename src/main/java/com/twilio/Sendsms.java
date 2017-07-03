package com.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/*Created By
		Lubaba Nuzhat Tasneem
		*/

//https://www.twilio.com/docs/quickstart/java/sms#overview
//http://www.journaldev.com/8118/gradle-eclipse-plugin-tutorial



public class Sendsms {
	public static final String Account_sid = System.getenv("A");
	public static final String Auth_token = System.getenv("b");
	
	public static void main(String [] args)
	{
		Twilio.init("AC82813d309984d60c6e299f503627443b", "b66ed61f6eca8e5131392ded9f6bc9b4");
		//
		Message message = Message.creator( 
						new PhoneNumber("+15712143827"),new PhoneNumber("+12408984566"),
						"This is where I am").setMediaUrl("https://c1.staticflickr.com/3/2899/14341091933_1e92e62d12_b.jpg")
				        .create();
		System.out.println(message.getSid());
		
	}

}