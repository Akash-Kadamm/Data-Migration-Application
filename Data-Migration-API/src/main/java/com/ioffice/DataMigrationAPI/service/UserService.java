package com.ioffice.DataMigrationAPI.service;

import com.ioffice.DataMigrationAPI.model.User;
import com.ioffice.DataMigrationAPI.repository.mysql.UserMysqlRepository;
import com.ioffice.DataMigrationAPI.repository.postgresql.UserPostgresqlRepositroy;
import com.ioffice.DataMigrationAPI.utility.ResponseMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMysqlRepository userMysqlRepository;

    @Autowired
    private UserPostgresqlRepositroy userPostgresqlRepositroy;


    public List<User> getAllUsers(){
        return userMysqlRepository.findAll();
    }

    public List<User>getAllUserByCompanyName(String companyName){
        return userMysqlRepository.getByUserCompanyName(companyName);
    }

    public User getUserById(int userId){
        return userMysqlRepository.findById(userId).get();
    }

    public ResponseMessages addUser(User user){
        User existedUser=userMysqlRepository.findById(user.getUserId()).get();
        if (existedUser == null) {
            return ResponseMessages.USER_ALREADY_REGISTERED;
        }
        User savedUser= userMysqlRepository.save(user);
        if (savedUser != null) {
            return ResponseMessages.USER_REGISTERED;
        }
        return ResponseMessages.USER_REGISTRATION_FAILED;
    }

    public ResponseMessages deleteUser(int userId){
        User savedUser=userMysqlRepository.findById(userId).get();
        if (savedUser != null) {
            userMysqlRepository.deleteById(userId);
            return ResponseMessages.USER_DELETED;
        }
        return ResponseMessages.USER_NOT_EXISTS;
    }


    public ResponseMessages updateUser(User user){
        User savedUser=userMysqlRepository.findById(user.getUserId()).get();
        if (savedUser != null) {
            savedUser.setUserEmail(user.getUserEmail());
            savedUser.setUserPassword(user.getUserPassword());
            savedUser.setUserCompanyName(user.getUserCompanyName());
            savedUser.setDepartment(user.getDepartment());
            userMysqlRepository.save(savedUser);
            return ResponseMessages.USER_UPDATED;
        }
        return ResponseMessages.USER_NOT_EXISTS;
    }


}
