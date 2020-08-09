package com.greenstore.utility;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.mail.SimpleMailMessage;

import com.greenstore.domain.User;

@Component
public class MailConstructor {

	@Autowired
	private Environment environment;

	public SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, User user,
			String password) {
		String url = contextPath + "/newUser?token=" + token;
		String messege = "\nPlease click on this link to verify your email and edit your personal information. Your password is: \n"
				+ password;
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("Green Bookstore new user");
		email.setText(url+messege);
		email.setFrom(environment.getProperty("support.email"));
		return email;
		

	}
}