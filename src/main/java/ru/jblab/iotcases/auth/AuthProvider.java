package ru.jblab.iotcases.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.jblab.iotcases.service.UserService;
import ru.jblab.iotcases.util.PasswordHelper;
import ru.jblab.iotcases.util.SecurityContextUtil;
import ru.jblab.iotcases.model.User;

/**
 * Created by ainurminibaev on 12.05.14.
 */
@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String password = authentication.getCredentials().toString();
        String email = authentication.getName();
        User user = userService.findUser(email);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        String hashedPassword = PasswordHelper.encrypt(password, user.getSalt());
        String generatedHash = PasswordHelper.encryptForGenerated(password, user.getSalt());
        if (user.getPassword().equals(hashedPassword) || generatedHash.equals(user.getPassword())) {
            return SecurityContextUtil.setAuthentication(user);
        } else {
            throw new BadCredentialsException("Bad user password");
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}
