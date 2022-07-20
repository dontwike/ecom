package com.eCom.demo.Config;

import com.eCom.demo.Model.Role;
import com.eCom.demo.Model.User;
import com.eCom.demo.Repository.RoleRepo;
import com.eCom.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class googleOAuth2SuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    public RoleRepo roleRepo;

    @Autowired
    public UserRepo userRepo;

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        String email = token.getPrincipal().getAttributes().get("email").toString();
        if(userRepo.findUserByEmail(email).isEmpty()){
            User user = new User();
            user.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());
            user.setLastName(token.getPrincipal().getAttributes().get("family_name").toString());
            user.setEmail(email);
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepo.findById(2L).get());
            user.setRoles(roles);
            userRepo.save(user);
        }
        redirectStrategy.sendRedirect(request, response, "/");
    }
}
