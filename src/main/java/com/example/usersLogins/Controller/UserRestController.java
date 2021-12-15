package com.example.usersLogins.Controller;

import java.util.List;

import com.example.usersLogins.Entity.User;
import com.example.usersLogins.Service.UserService;

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
@RequestMapping("/api") //URL raiz para la api
public class UserRestController {
    
    //Inyeccion del servicio
    @Autowired
    private UserService userService;
    //Método para GET
    @GetMapping("/users")
    public List<User> findAll(){
        //Retorno de todos los usuarios
        return userService.findAll();
    }
    //Método para GET con ID
    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId){
        User user = userService.findById(userId);

        if(user == null){
            throw new RuntimeException("User id not found -" + userId);
        }else{
            return user;
        }
    }
    //Metodo para POST
    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        user.setId(0);
        userService.save(user);
        return user;
    }
    //Método para PUT
    @PutMapping("/users")
    public User updateUser(User user){
        userService.save(user);
        return user;
    }
    @DeleteMapping("/users/{userID}")
    public String deleteUser(@PathVariable int userID){
        
        User user = userService.findById(userID);
        if(user == null){
            throw new RuntimeException("User id not found -"+ userID);
        }else{
            userService.deleteByID(userID);
            return "Deleted user ID- " + userID;
        }
    }
}
