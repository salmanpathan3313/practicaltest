package com.crudopration.practicaltest.service.impl;

import com.crudopration.practicaltest.model.entity.User;
import com.crudopration.practicaltest.repository.UserRepository;
import com.crudopration.practicaltest.service.iface.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.ResponseEntity.status;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired UserRepository userRepository;

    @Override
    public boolean saveUser(User user) {
        
//        try {
            userRepository.save(user);
            return true;
//        } catch (Exception e) {
//            throw new ResponseEntity(HttpStatus.BAD_REQUEST, "not add items");
//        }
    }
    
    @Override
    public User findById(String id){
      return  userRepository.findByUserId(id);
    }
    
    @Override
    public List<User> getAllUserList(List<String> status){
        return userRepository.getAllUserList(status);
    }
    
    @Override
    public List<User> findByUserMobileAndStatusIn(String mobile, List<String> status){
        return userRepository.findByUserMobileAndStatusIn(mobile,status);
    }
    
}
