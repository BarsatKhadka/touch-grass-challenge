package com.barsat.touch_grass.Security.Service;

import com.barsat.touch_grass.Entity.TheUser;
import com.barsat.touch_grass.Entity.TheUserSecurityDetails;
import com.barsat.touch_grass.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //look if user is in database
        TheUser user = userRepo.findByUsername(username);

        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User with " + username + " not found");
        }

        //if the user is found , then pass that user to TheUserSecurityDetails to create UserDetailsType to return.
        return new TheUserSecurityDetails(user);
    }
}