package com.crudopration.practicaltest.service.impl;

import com.crudopration.practicaltest.model.entity.User;
import com.crudopration.practicaltest.model.entity.UserDetailsMapping;
import com.crudopration.practicaltest.repository.UserDetailsMappingRepository;
import com.crudopration.practicaltest.repository.UserRepository;
import com.crudopration.practicaltest.service.iface.UserDetailsMappingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsMappingServiceImpl implements UserDetailsMappingService{
    
    @Autowired UserDetailsMappingRepository userDetailsMappingRepository;

    @Override
    public boolean saveUserDetailsMapping(UserDetailsMapping userDetailsMapping){
        
//        try {
            userDetailsMappingRepository.save(userDetailsMapping);
            return true;
//        } catch (Exception e) {
//            throw new ResponseEntity(HttpStatus.BAD_REQUEST, "not add items");
//        }
    }
    
    
    @Override
    public List<UserDetailsMapping> findByUserIdAndStatusIn(String userId, List<String> status){
        return userDetailsMappingRepository.findByUserIdAndStatusIn(userId,status);
    }
    
//    @Override
//    public User findById(String id){
////      return  userDetailsMappingRepository.findByUserDetaisId(id);
//    }
//    
//    @Override
//    public List<User> getAllUserList(List<String> status){
////        return userDetailsMappingRepository.getAllUserDetailsList(status);
//    }
    
}
