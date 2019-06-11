package com.tvisha.Utility;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class Email {
public static void main(String[] args) throws EmailException, MalformedURLException {
	  // Create the attachment
	
	
 /*SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("rakeshadupa96@gmail.com", "recommend139"));
		email.setSSL(true);
	 email.setFrom("rakeshadupa96@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ...");
		email.addTo("rakeshadupa931@gmail.com");
	email.send();*/
	EmailAttachment attachment = new EmailAttachment();
	attachment.setPath("D:\\Springworkspace\\SeleniumNewFramework\\test-output\\emailable-report.html");
	attachment.setDisposition(EmailAttachment.ATTACHMENT);
	attachment.setDescription("reports");
	attachment.setName("rakesh");


MultiPartEmail email = new MultiPartEmail();
	email.setHostName("smtp.gmail.com");
	email.setSubject("The picture");
	email.setMsg("Here is the picture you wanted");
	email.setFrom("sathish.kumar@tvisha.in");
	email.setSmtpPort(587);
	email.setAuthenticator(new DefaultAuthenticator("b.sathishkumar2907@gmail.com", "29071992"));
	email.setSSL(true);
	email.addTo("sathish.kumar@tvisha.in");
	email.attach(attachment);
	email.send();
	
 }
}
