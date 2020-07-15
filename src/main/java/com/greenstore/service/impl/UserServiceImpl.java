package com.greenstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenstore.domain.User;
import com.greenstore.domain.security.PasswordResetToken;
import com.greenstore.service.UserService;
import com.greenstore.repository.passwordResetTokenRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private passwordResetTokenRepository passwordResetTokenRepository;
	
	@Override
	public PasswordResetToken getPasswordResetToken(final String token) {
		return passwordResetTokenRepository.findByToken(token);
	}

	@Override
	public void createPasswordResetTokenForUser(final User user,final String token) {
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(myToken);
	}

}
