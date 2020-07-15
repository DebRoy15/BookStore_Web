package com.greenstore.service;

import com.greenstore.domain.User;
import com.greenstore.domain.security.PasswordResetToken;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);

}
