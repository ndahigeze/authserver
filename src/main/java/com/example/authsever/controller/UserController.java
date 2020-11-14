package com.example.authsever.controller;

import com.example.authsever.UserRepository;
import com.example.authsever.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "auth",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String createUser(@RequestBody SystemUser user){
        BCryptPasswordEncoder b=new BCryptPasswordEncoder();
        user.setPassword(b.encode(user.getPassword()));
        user.setEnabled(true);
        System.out.println(user.getPassword());
        userRepository.save(user);
        return "Saved";
    }


    @RequestMapping(value = "users",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String all(@RequestBody SystemUser user){

        return "Saved";
    }




}
