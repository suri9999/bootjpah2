package com.example.bootjpah2.Controller;

import com.example.bootjpah2.DAO.UserRepo;
import com.example.bootjpah2.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/adduser")
    public User adduser(@RequestBody User user){
        System.out.println("In add user page");
        userRepo.save(user);
        return user;
    }

    @DeleteMapping("/deleteuser/{uid}")
    public String deleteUser(@PathVariable int uid){
        User u1=userRepo.getById(uid);
        System.out.println("in Delete method");
        userRepo.delete(u1);
        return "Deleted";
    }

    @PutMapping("/updateuser")
    public User updateUser(@RequestBody User user){
        userRepo.save(user);
        return user;
    }


    @RequestMapping(value = "/getusers")
    public List<User> getAllUser(){
       return userRepo.findAll();

    }

    @RequestMapping("/getusers/{uid}")
    @ResponseBody
    public Optional<User> getAllUser(@PathVariable("uid") int uid){
        return userRepo.findById(uid);
    }



}
