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
	public static final String Account_sid = System.getenv("");
	public static final String Auth_token = System.getenv("");
	
	public static void main(String [] args)
	{
		
		Twilio.init("","");
		//
		Message message = Message.creator( 
						new PhoneNumber(""),new PhoneNumber("+12408984566"),
						"This is where I am").setMediaUrl("https://c1.staticflickr.com/3/2899/14341091933_1e92e62d12_b.jpg")
				        .create();
		System.out.println(message.getSid());
		
	}

	public static void send(String msg)
	{
		Message message = Message.creator( 
				new PhoneNumber("+15712143827"),new PhoneNumber("+12408984566"),
				msg).setMediaUrl("https://c1.staticflickr.com/3/2899/14341091933_1e92e62d12_b.jpg")
		        .create();
	}
}