package com.joblink.joblinktest01.service;

import com.joblink.joblinktest01.dto.UserDTO;
import com.joblink.joblinktest01.entity.UserEntity;
import com.joblink.joblinktest01.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, UserEntity.class));
        return  userDTO;
    }
    public List<UserDTO> getAllUsers(){
        List<UserEntity>userList = userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO,UserEntity.class));
        return userDTO;
    }
    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO,UserEntity.class));
        return true;
    }

    //select * from user_Entity where id = 1
    public UserDTO getUserByUserID(String userID){
        UserEntity userEnt= userRepo.getUserByUserID(userID);
        return modelMapper.map(userEnt,UserDTO.class);
    }
    public UserDTO getUserbyIdAddress (String userID,String address){
        UserEntity userEnt= userRepo.getUserByIdAddress(userID,address);
        return modelMapper.map(userEnt,UserDTO.class);
    }

}
