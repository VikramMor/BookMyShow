package com.example.BMS.Controller;

import com.example.BMS.Dto.UserRequestDto;
import com.example.BMS.Model.UserEntity;
import com.example.BMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody() UserRequestDto userRequestDto){
        String response = userService.createUser(userRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get_by_name/{name}")
    public ResponseEntity<List<UserEntity>> getUserByName(@PathVariable String name){
        List<UserEntity> list = userService.getUserByName(name);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        List<UserEntity> list = userService.getAllUsers();
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }
}