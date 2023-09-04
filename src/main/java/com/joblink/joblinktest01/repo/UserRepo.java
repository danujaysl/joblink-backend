package com.joblink.joblinktest01.repo;

import com.joblink.joblinktest01.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {

    @Query(value = "select * from user_Entity where id= ?1",nativeQuery = true)
    UserEntity getUserByUserID(String userID);

    @Query(value ="select * from user_Entity where id=?1 and address=?2",nativeQuery = true)
    UserEntity getUserByIdAddress (String useID,String address);
}
