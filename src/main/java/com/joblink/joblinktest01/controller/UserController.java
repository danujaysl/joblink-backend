package com.joblink.joblinktest01.controller;

import com.joblink.joblinktest01.dto.UserDTO;
import com.joblink.joblinktest01.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getUser")
    public List<UserDTO> getUser(){
        return userService.getAllUsers();
    }
    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }
    @PutMapping("/updateUser")
    public UserDTO UpdUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }
    @DeleteMapping("/deleteUser")
    public boolean delUser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);
    }

    @PatchMapping("/patchUser")
    public String patchUser(){
        return "Patch is OK";
    }

    @GetMapping("/getUserbyID/{userID}")
    public UserDTO getUserByUserID(@PathVariable String userID){
        return userService.getUserByUserID(userID);
    }

    @GetMapping("/getUserbyIdAddress/{userID}/{address}")
    public UserDTO getUserByIdAddress(@PathVariable String userID,@PathVariable String address){
        System.out.println("User id is: "+userID +"Address is : "+address);
        return  userService.getUserbyIdAddress(userID,address);
    }

}
