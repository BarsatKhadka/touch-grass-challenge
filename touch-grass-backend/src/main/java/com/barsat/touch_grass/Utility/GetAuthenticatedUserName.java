package com.barsat.touch_grass.Utility;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class GetAuthenticatedUserName {

    public String getUsername(){

        //get the username and find the user to set the user in collections record.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = null;

        if(authentication != null ){
            username = authentication.getName();
        }

        else{

            return "not found";

        }
        return username;
    }

}
