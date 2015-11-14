package ru.jblab.iotcases.util;

import org.jetbrains.annotations.Nullable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.jblab.iotcases.model.User;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created on 31.08.2014.
 */
public class SecurityContextUtil {

    public static @Nullable
    User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return isNoAuth(authentication) ? null : (User) authentication.getPrincipal();
    }


    public static @Nullable Collection<? extends GrantedAuthority> getCurrentUserRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return isNoAuth(authentication) ? null : authentication.getAuthorities();
    }

    public static @Nullable Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return isNoAuth(authentication) ? null : ((User) authentication.getPrincipal()).getId();
    }

    private static boolean isNoAuth(Authentication authentication) {
        return authentication == null || !(authentication instanceof UsernamePasswordAuthenticationToken);
    }

    public static Authentication setAuthentication(User user) {
        Authentication authToken =
                new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_" + user.getGroup().name())));
        SecurityContextHolder.getContext().setAuthentication(authToken);
        return authToken;
    }


    public static boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !isNoAuth(authentication);
    }
}
