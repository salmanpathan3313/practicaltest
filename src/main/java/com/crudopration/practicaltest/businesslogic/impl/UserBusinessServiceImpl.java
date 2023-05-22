package com.crudopration.practicaltest.businesslogic.impl;


import com.crudopration.practicaltest.common.BaseResponse;
import com.crudopration.practicaltest.model.dto.UserRequestDto;
import com.crudopration.practicaltest.model.entity.User;
import com.crudopration.practicaltest.service.iface.UserService;
import com.crudopration.practicaltest.businesslogic.iface.UserBusinessService;
import com.crudopration.practicaltest.common.constant.Constants;
import com.crudopration.practicaltest.model.dto.UserDetailsMappingRequestDto;
import com.crudopration.practicaltest.model.entity.UserDetailsMapping;
import com.crudopration.practicaltest.service.iface.UserDetailsMappingService;
import com.crudopration.practicaltest.util.iface.ServiceUtil;
import com.crudopration.practicaltest.utils.CommonUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessServiceImpl implements UserBusinessService{
    
    @Autowired UserService userService;
    
    @Autowired ServiceUtil serviceUtil;
    
    @Autowired UserDetailsMappingService userDetailsMappingService;

    @Override
    public BaseResponse addUser(UserRequestDto user) {
        
      
            User user1 = new User();
            
            List<User> mobile = userService.findByUserMobileAndStatusIn(user.getMobile(), CommonUtil.userDetailsStatus());
            
            if(mobile == null){
                if(user.getUserName() != null || !user.getUserName().equals("")){
                    user1.setUserName(user.getUserName());
                }
                if(user.getEmail()!= null || !user.getEmail().equals("")){
                    user1.setEmail(user.getEmail());
                }
                if(user.getMobile()!= null || !user.getMobile().equals("")){
                    user1.setMobile(user.getMobile());
                }
               
                user1.setStatus(Constants.ACTIVE);
                userService.saveUser(user1);

                for(UserDetailsMappingRequestDto userDetailsField: user.getUserDetailsField()){

                    UserDetailsMapping userDetailsMapping =  new UserDetailsMapping();
                    
                    if(userDetailsField.getAddress()!= null || !userDetailsField.getAddress().equals("")){
                        userDetailsMapping.setAddress(userDetailsField.getAddress());
                    }
                    if(userDetailsField.getAddress()!= null || !userDetailsField.getAddress().equals("")){
                        userDetailsMapping.setCity(userDetailsField.getCity());
                    }
                    if(userDetailsField.getAddress()!= null || !userDetailsField.getAddress().equals("")){
                        
                        userDetailsMapping.setState(userDetailsField.getState());
                    }
                    if(userDetailsField.getAddress()!= null || !userDetailsField.getAddress().equals("")){
                        
                        userDetailsMapping.setCountry(userDetailsField.getCountry());
                    }
                    if(userDetailsField.getAddress()!= null || !userDetailsField.getAddress().equals("")){
                        
                        userDetailsMapping.setPincode(userDetailsField.getPincode());
                    }
                        
                        userDetailsMapping.setStatus(Constants.ACTIVE);
                        userDetailsMapping.setUserId(user1);
                        userDetailsMappingService.saveUserDetailsMapping(userDetailsMapping);
                }


                BaseResponse baseResponse = new BaseResponse(true, HttpStatus.OK.value(), HttpStatus.OK, "Add Notification successful.");
                return baseResponse;
            }else{
                return  new BaseResponse(true, HttpStatus.OK.value(), HttpStatus.OK, "Mobile Number Alrady Exist");
            }
            
    }
    
    @Override
    public BaseResponse editUser(String id, UserRequestDto userRequestDto){
        
        User user = userService.findById(id);
        
        if(user != null && !user.equals("")){
            
            User updateUser = user;
            
            if(userRequestDto.getUserName()!= null || !userRequestDto.getUserName().equals("")){
                updateUser.setUserName(userRequestDto.getUserName());
            }
            if(userRequestDto.getMobile()!= null || !userRequestDto.getMobile().equals("")){
                updateUser.setMobile(userRequestDto.getMobile());
            }
            if(userRequestDto.getEmail()!= null || !userRequestDto.getEmail().equals("")){
                updateUser.setEmail(userRequestDto.getEmail());
            }
            
            updateUser.setStatus(Constants.ACTIVE);
            userService.saveUser(updateUser);

        }
        
        
        List<UserDetailsMapping> userId = userDetailsMappingService.findByUserIdAndStatusIn(id, CommonUtil.userDetailsStatus());
            
        
        for (UserDetailsMapping userDetailsField : userId) {
            userDetailsField.setStatus(Constants.DELETED);
            userDetailsMappingService.saveUserDetailsMapping(userDetailsField);
        }
        
        
         for(UserDetailsMappingRequestDto userDetailsField: userRequestDto.getUserDetailsField()){

                    UserDetailsMapping userDetailsMapping1 =  new UserDetailsMapping();
                    
                    if(userDetailsField.getAddress()!= null || !userDetailsField.getAddress().equals("")){
                        userDetailsMapping1.setAddress(userDetailsField.getAddress());
                    }
                    if(userDetailsField.getCity()!= null || !userDetailsField.getCity().equals("")){
                        userDetailsMapping1.setCity(userDetailsField.getCity());
                    }
                    if(userDetailsField.getState()!= null || !userDetailsField.getState().equals("")){
                        userDetailsMapping1.setState(userDetailsField.getState());
                    }
                    if(userDetailsField.getCountry()!= null || !userDetailsField.getCountry().equals("")){
                        userDetailsMapping1.setCountry(userDetailsField.getCountry());
                     }
                    if(userDetailsField.getPincode()!= null || !userDetailsField.getPincode().equals("")){
                        userDetailsMapping1.setPincode(userDetailsField.getPincode());
                    }
                    
                    userDetailsMapping1.setStatus(Constants.ACTIVE);
                    userDetailsMapping1.setUserId(user);
                    userDetailsMappingService.saveUserDetailsMapping(userDetailsMapping1);
                    }
            
            return new BaseResponse(true, HttpStatus.OK.value(), HttpStatus.OK, "Packages.update.successfull");
    }   
       
    
    
    
    @Override
    public BaseResponse deleteUser(String id){
        
        User user = userService.findById(id);
        
        if (user != null) {
            user.setStatus(Constants.DELETED);
            userService.saveUser(user);
            
            List<UserDetailsMapping> userId = userDetailsMappingService.findByUserIdAndStatusIn(id, CommonUtil.userDetailsStatus());
            for(UserDetailsMapping userDetailsMapping: userId){
                userDetailsMapping.setStatus(Constants.DELETED);
                userDetailsMappingService.saveUserDetailsMapping(userDetailsMapping);
            }
        }
        
        return new BaseResponse(true, HttpStatus.OK.value(), HttpStatus.OK,  "Deleted Successfully");
    }
    

    
    @Override
    public BaseResponse getAllUser(){
        
        
        List<User> userList =  userService.getAllUserList(CommonUtil.userStatus());
        List<UserRequestDto> userListModel = serviceUtil.convertUserListModel(userList);
        
        return new BaseResponse(true, HttpStatus.OK.value(), HttpStatus.OK, userListModel);
 
    }
    
    @Override
    public BaseResponse getOneUser(String id){
        
         User user = userService.findById(id);
         
          UserRequestDto userListModel = new UserRequestDto();
        if (user != null) {
            userListModel = serviceUtil.convertUserListModel(user);
        }
        return new BaseResponse(true, HttpStatus.OK.value(), HttpStatus.OK, userListModel);
   
    }

  
}
