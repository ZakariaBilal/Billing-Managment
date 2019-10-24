package com.anp.gestion_facturation.service;

import com.anp.gestion_facturation.model.dao.UserRepo;
import com.anp.gestion_facturation.model.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserPrincipalDetailService
 */
@Service
public class UserPrincipalDetailService implements UserDetailsService {
    private UserRepo userRepo;

    @Autowired
    public UserPrincipalDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepo.findByUsername(username);
        UserPrincipal userPrincipal = new UserPrincipal(user);

        return userPrincipal;
    }

}