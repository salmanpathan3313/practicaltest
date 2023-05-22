package com.crudopration.practicaltest.service.iface;

import com.crudopration.practicaltest.model.entity.User;
import java.util.List;


public interface UserService {

    public boolean saveUser(User user);

    public User findById(String id);
 
    public List<User> getAllUserList(List<String> status);

    public List<User> findByUserMobileAndStatusIn(String mobile, List<String> status);
}

