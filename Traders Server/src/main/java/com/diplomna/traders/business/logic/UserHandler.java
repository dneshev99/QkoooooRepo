package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.UserDTO;
import com.diplomna.traders.models.User;
import com.diplomna.traders.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserHandler implements UserDetailsService{
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserRepository userRepo;
    
    public User registerNewUserAccount(UserDTO accountDto) throws Exception{
        if(loadUserByUsername(accountDto.getUsername()) == null) {
            User newUser = new User(accountDto.getUsername(), passwordEncoder.encode(accountDto.getPassword()), accountDto.getEmail(), accountDto.getPhone(), accountDto.getAccountType());
            userRepo.save(newUser);
            return newUser;
        }else{
            return null;
        }
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return userRepo.findByUsername(username);
        }catch(UsernameNotFoundException e){
            throw e;
        }
    }
}
