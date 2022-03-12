package com.cn.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public List<User> name(){
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User GetUser(@PathVariable Integer id){
        return userRepo.findById(id).orElse(null);
    }
    @PostMapping("/")
    public User PostUser(@RequestBody User user){
        return userRepo.save(user);
    }
    @PutMapping("/")
    public User PutUser(@RequestBody User user){
        User oldUser = userRepo.findById(user.getId()).orElse(null);
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        return userRepo.save(oldUser);
    }
    @DeleteMapping("/")
    public Integer DeleteUser(@PathVariable Integer id){
        userRepo.deleteById(id);
        return id;
    }
}
