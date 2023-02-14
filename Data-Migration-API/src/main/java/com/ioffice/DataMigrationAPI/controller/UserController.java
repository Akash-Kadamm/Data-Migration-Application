package com.ioffice.DataMigrationAPI.controller;

import com.ioffice.DataMigrationAPI.dto.UserDto;
import com.ioffice.DataMigrationAPI.model.User;
import com.ioffice.DataMigrationAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(
                userService.getAllUsers(),
                HttpStatus.OK
        );
    }

    @GetMapping("/getAllUsersByCompanyName/{companyName}")
    public ResponseEntity<List<User>> getAllUsersOfCompany(@PathVariable String companyName){
        return new ResponseEntity<>(
          userService.getAllUserByCompanyName(companyName),
          HttpStatus.OK
        );
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int userId){
       User user= userService.getUserById(userId);
       UserDto userDto=UserDto.builder()
               .userId(user.getUserId())
               .userName(user.getUserName())
               .userCompanyName(user.getUserCompanyName()).build();
       return new ResponseEntity<>(
          userDto,
          HttpStatus.OK
        );
    }

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody  User user){
        return new ResponseEntity<>(
          userService.addUser(user),
          HttpStatus.CREATED
        );
    }

    @PatchMapping("/updatedUser")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        return new ResponseEntity<>(
          userService.updateUser(user),
          HttpStatus.OK
        );
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId){
        return new ResponseEntity<>(
          userService.deleteUser(userId),
          HttpStatus.OK
        );
    }


}
