package com.crudopration.practicaltest.controller;

import com.crudopration.practicaltest.common.BaseResponse;
import com.crudopration.practicaltest.model.dto.UserRequestDto;
import com.crudopration.practicaltest.businesslogic.iface.UserBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired UserBusinessService userBusinessService;
    
    @PostMapping("/add")
    public ResponseEntity addUser(
            @RequestBody(required = true) UserRequestDto user
    ){
        System.out.println(" Enter Add User");
        
        BaseResponse baseResponse = userBusinessService.addUser(user);
        
        return new ResponseEntity(baseResponse, baseResponse.getHttpStatus());
    }
    
    
    @PostMapping("/edit/{id}")
    public ResponseEntity editUser(
            @RequestBody(required = true) UserRequestDto userRequestDto,
            @PathVariable("id") String id
    ){
        System.out.println(" Enter Edit User");
        
        BaseResponse baseResponse = userBusinessService.editUser(id,userRequestDto);
        
       return new ResponseEntity(baseResponse, baseResponse.getHttpStatus());
    }
    
     @GetMapping("/delete/{id}")
    public ResponseEntity deleteUser(
            @PathVariable("id") String id
    ){
        System.out.println(" Enter Delete User");
        
        BaseResponse baseResponse = userBusinessService.deleteUser(id);
        
        return new ResponseEntity(baseResponse, baseResponse.getHttpStatus());
    }
    

     @GetMapping("/getone/{id}")
    public ResponseEntity getOneUsers(
        @PathVariable("id") String id
    ){
        System.out.println(" Enter Get One User");
        
        BaseResponse baseResponse = userBusinessService.getOneUser(id);
        
        return new ResponseEntity(baseResponse, baseResponse.getHttpStatus());
    }
    


     @GetMapping("/list")
    public ResponseEntity getAllUsers(
    ){
        System.out.println(" Enter Get All User");
        
        BaseResponse baseResponse = userBusinessService.getAllUser();
        
        return new ResponseEntity(baseResponse, baseResponse.getHttpStatus());
    }
        
    
}
