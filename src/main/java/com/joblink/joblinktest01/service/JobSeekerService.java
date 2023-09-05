package com.joblink.joblinktest01.service;

import com.joblink.joblinktest01.dto.JobSeekerDTO;
import com.joblink.joblinktest01.entity.jobseeker;
import com.joblink.joblinktest01.repo.JobSeekerRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class JobSeekerService {
    @Autowired
    private JobSeekerRepo jobSeekerRepo;
    @Autowired
    private ModelMapper modelMapper;
    public JobSeekerDTO saveUser(JobSeekerDTO jobSeekerDTO){
        jobSeekerRepo.save(modelMapper.map(jobSeekerDTO, jobseeker.class));
        return  jobSeekerDTO;
    }
    public List<JobSeekerDTO> getAllUsers(){
        List<jobseeker>userList = jobSeekerRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<JobSeekerDTO>>(){}.getType());
    }

    public JobSeekerDTO updateUser(JobSeekerDTO jobSeekerDTO){
        jobSeekerRepo.save(modelMapper.map(jobSeekerDTO,jobseeker.class));
        return jobSeekerDTO;
    }
    public boolean deleteUser(JobSeekerDTO jobSeekerDTO){
        jobSeekerRepo.delete(modelMapper.map(jobSeekerDTO,jobseeker.class));
        return true;
    }

    //select * from user_Entity where id = 1
    public JobSeekerDTO getid(Integer n_jobseekerid){
        jobseeker js = jobSeekerRepo.getid(n_jobseekerid);
        return modelMapper.map(js,JobSeekerDTO.class);
    }
    // public JobSeekerDTO getUserbyIdAddress (String userID,String address){
    //     jobseeker userEnt= jobSeekerRepo.getUserByIdAddress(userID,address);
    //     return modelMapper.map(userEnt,JobSeekerDTO.class);
    // }

}
