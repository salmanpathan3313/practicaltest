package com.crudopration.practicaltest.service.iface;

import com.crudopration.practicaltest.model.entity.UserDetailsMapping;
import java.util.List;


public interface UserDetailsMappingService {

    public boolean saveUserDetailsMapping(UserDetailsMapping userDetailsMapping);
    
    List<UserDetailsMapping> findByUserIdAndStatusIn(String userId, List<String> status);
 

//    public User findById(String id);
// 
//    public List<User> getAllUserList(List<String> status);
}

