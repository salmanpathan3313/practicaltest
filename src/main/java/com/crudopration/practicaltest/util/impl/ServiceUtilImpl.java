package com.crudopration.practicaltest.util.impl;


import com.crudopration.practicaltest.common.constant.Constants;
import com.crudopration.practicaltest.model.dto.UserDetailsMappingRequestDto;
import com.crudopration.practicaltest.model.dto.UserRequestDto;
import com.crudopration.practicaltest.model.entity.User;
import com.crudopration.practicaltest.model.entity.UserDetailsMapping;
import com.crudopration.practicaltest.service.iface.UserDetailsMappingService;
import com.crudopration.practicaltest.util.iface.ServiceUtil;
import com.crudopration.practicaltest.utils.CommonUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ServiceUtilImpl implements ServiceUtil{
    
@Autowired UserDetailsMappingService userDetailsMappingService;
    
@Override
    public List<UserRequestDto> convertUserListModel(List<User> user) {
        List<UserRequestDto> userRequestDtoList = new ArrayList<>();

        for (User user1 : user) {
            UserRequestDto userRequestDto = convertUserListModel(user1);
            userRequestDtoList.add(userRequestDto);
        }
        return userRequestDtoList;

    }
    
    @Override
    public UserRequestDto convertUserListModel(User user) {
      
        UserRequestDto userRequestDto = new UserRequestDto();
        
        userRequestDto.setId(user.getId());
        if(user.getUserName()!= null || !user.getUserName().equals("")){
            userRequestDto.setUserName(user.getUserName());
        }
        
        if(user.getEmail()!= null || !user.getEmail().equals("")){
            userRequestDto.setEmail(user.getEmail());
        }
        if(user.getMobile()!= null || !user.getMobile().equals("")){
            userRequestDto.setMobile(user.getMobile());
        }
        
        userRequestDto.setStatus(user.getStatus());
        
        
        List<UserDetailsMapping> userId = userDetailsMappingService.findByUserIdAndStatusIn(user.getId(), CommonUtil.userDetailsStatus());
        
         if (userId != null) {

            List<UserDetailsMappingRequestDto> mappedUserDetailsFields = new ArrayList<>();

            for (UserDetailsMapping userDetailsMapping : userId) {
                if (userDetailsMapping.getStatus().equals(Constants.ACTIVE)) {
                    UserDetailsMappingRequestDto userDetailsMappingRequestDto = new UserDetailsMappingRequestDto();
                    userDetailsMappingRequestDto.setId(userDetailsMapping.getId());
                    
                    if(userDetailsMapping.getAddress()!= null || !userDetailsMapping.getAddress().equals("")){
                        userDetailsMappingRequestDto.setAddress(userDetailsMapping.getAddress());
                    }
                    if(userDetailsMapping.getCity()!= null || !userDetailsMapping.getCity().equals("")){
                        userDetailsMappingRequestDto.setCity(userDetailsMapping.getCity());
                    
                    }
                    if(userDetailsMapping.getState()!= null || !userDetailsMapping.getState().equals("")){
                       userDetailsMappingRequestDto.setState(userDetailsMapping.getState());
                    }
                    if(userDetailsMapping.getCountry()!= null || !userDetailsMapping.getCountry().equals("")){
                        userDetailsMappingRequestDto.setCountry(userDetailsMapping.getCountry());
                    
                    }
                    if(userDetailsMapping.getPincode()!= null || !userDetailsMapping.getPincode().equals("")){
                        userDetailsMappingRequestDto.setPincode(userDetailsMapping.getPincode());
                    
                    }
                   
                    if(userDetailsMapping.getUserId().getId()!= null || !userDetailsMapping.getUserId().getId().equals("")){
                        userDetailsMappingRequestDto.setUserId(userDetailsMapping.getUserId().getId());
                        userDetailsMappingRequestDto.setUserIdName(userDetailsMapping.getUserId().getUserName());
                    }
                    
                    userDetailsMappingRequestDto.setStatus(userDetailsMapping.getState());
                  
                    mappedUserDetailsFields.add(userDetailsMappingRequestDto);
                    
                }
            }    
            userRequestDto.setUserDetailsField(mappedUserDetailsFields);
        }
        
        return userRequestDto;
            
    }
    
}
