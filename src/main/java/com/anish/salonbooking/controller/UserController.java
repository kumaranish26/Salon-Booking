package com.anish.salonbooking.controller;

import com.anish.salonbooking.model.User;
import com.anish.salonbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }
    @GetMapping("/api/users")
    public User getUser()
    {
        User user=new User();
        user.setFullName("Anish Kumar");
        user.setEmail("anishonly@gmail.com");
        user.setPhone("+91 7070925856");
        user.setRole("Customer");
        return user;
    }
    @GetMapping("/api/user/{id}")
    public User getUserById(@PathVariable Long id) throws Exception
    {
        Optional<User> otp=userRepository.findById(id);
        if(otp.isPresent())
        {
            return otp.get();

        }
        throw new Exception("User not found");
    }

}
