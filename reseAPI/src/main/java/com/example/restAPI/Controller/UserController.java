package com.example.restAPI.Controller;

import com.example.restAPI.Entity.UserEntity;
import com.example.restAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping
    public UserEntity put(@RequestParam String email, @RequestParam String password, @RequestParam String name, @RequestParam String allergy){
        return userRepository.save(new UserEntity(email,password,name,allergy));
    }

    @GetMapping
    public Iterable<UserEntity> list(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<UserEntity> findOne(@PathVariable Long id){
        return userRepository.findById(id);
    }

    @PutMapping(value = "/{id}")
    public UserEntity update(@PathVariable Long id, @RequestParam String email, @RequestParam String password, @RequestParam String name, @RequestParam String allergy ){
        Optional<UserEntity> userEntity = userRepository.findById(id);
        userEntity.get().setEmail(email);
        userEntity.get().setPassword(password);
        userEntity.get().setName(name);
        userEntity.get().setAllergy(allergy);
        return userRepository.save(userEntity.get());
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        userRepository.deleteById(id);
    }
}