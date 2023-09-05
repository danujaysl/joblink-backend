package com.joblink.joblinktest01.controller;
import com.joblink.joblinktest01.dto.JobSeekerDTO;
import com.joblink.joblinktest01.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping(value = "api/user")
public class JobSeekerController {
    @Autowired
    private JobSeekerService jobSeekerService;
    @GetMapping("/getUser")
    public List<JobSeekerDTO> getUser(){
        return jobSeekerService.getAllUsers();
    }
    @PostMapping("/saveUser")
    public JobSeekerDTO saveUser(@RequestBody JobSeekerDTO jobSeekerDTO){
        return jobSeekerService.saveUser(jobSeekerDTO);
    }
    @PutMapping("/updateUser")
    public JobSeekerDTO UpdUser(@RequestBody JobSeekerDTO jobSeekerDTO){
        return jobSeekerService.updateUser(jobSeekerDTO);
    }
    @DeleteMapping("/deleteUser")
    public boolean delUser(@RequestBody JobSeekerDTO jobSeekerDTO){
        return jobSeekerService.deleteUser(jobSeekerDTO);
    }

    @PatchMapping("/patchUser")
    public String patchUser(){
        return "Patch is OK";
    }

    @GetMapping("/getjsbyID/{n_jobseekerid}")
    public JobSeekerDTO getid(@PathVariable Integer n_jobseekerid){
        return jobSeekerService.getid(n_jobseekerid);
    }

    // @GetMapping("/getUserbyIdAddress/{userID}/{address}")
    // public JobSeekerDTO getUserByIdAddress(@PathVariable String userID,@PathVariable String address){
    //     System.out.println("User id is: "+userID +"Address is : "+address);
    //     return  userService.getUserbyIdAddress(userID,address);
    // }

}
