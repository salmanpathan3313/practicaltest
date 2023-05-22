package com.crudopration.practicaltest.util.iface;

import com.crudopration.practicaltest.model.dto.UserRequestDto;
import com.crudopration.practicaltest.model.entity.User;
import java.util.List;

public interface ServiceUtil {

    public List<UserRequestDto> convertUserListModel(List<User> userList);
    
    UserRequestDto convertUserListModel(User user);

    
}
