package com.project1.controller;

import java.io.IOException;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

public class AWSHelper {

	// Replace sender@example.com with your "From" address.
	// This address must be verified with Amazon SES.
	static final String FROM = "gpcompany9@gmail.com";

	// Replace recipient@example.com with a "To" address. If your account
	// is still in the sandbox, this address must be verified.
	

	// The configuration set to use for this email. If you do not want to use a
	// configuration set, comment the following variable and the
	// .withConfigurationSetName(CONFIGSET); argument below.
	// static final String CONFIGSET = "ConfigSet";

	// The subject line for the email.
	static final String SUBJECT = "temporary password";

	public static void sendMail(String password, String email) {

		try {
			String TO = email;
			// The HTML body for the email.
			String HTMLBODY = "<h1>GandP Company</h1>" + "<p>Your temporary password is: " + password;
			// The email body for recipients with non-HTML email clients.
			String TEXTBODY = "Your temporary password is: " + password;

			AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
					// Replace US_WEST_2 with the AWS Region you're using for
					// Amazon SES.
					.withRegion(Regions.US_EAST_1).build();
			SendEmailRequest request = new SendEmailRequest().withDestination(new Destination().withToAddresses(TO))
					.withMessage(new Message()
							.withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(HTMLBODY))
									.withText(new Content().withCharset("UTF-8").withData(TEXTBODY)))
							.withSubject(new Content().withCharset("UTF-8").withData(SUBJECT)))
					.withSource(FROM);
			// Comment or remove the next line if you are not using a
			// configuration set
			// .withConfigurationSetName(CONFIGSET);
			client.sendEmail(request);
			System.out.println("Email sent!");
		} catch (Exception ex) {
			System.out.println("The email was not sent. Error message: " + ex.getMessage());
		}
	}
}
