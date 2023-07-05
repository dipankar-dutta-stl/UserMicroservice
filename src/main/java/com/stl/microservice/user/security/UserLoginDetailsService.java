package com.stl.microservice.user.security;

import com.stl.microservice.user.model.User;
import com.stl.microservice.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoginDetailsService implements UserDetailsService {
    @Autowired
    UserRepo USER_REPPO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User USER=USER_REPPO.findByUniqueId(username);
        if(USER!=null){
            return new UserLoginDetails(USER);
        }
        return null;
    }
}
