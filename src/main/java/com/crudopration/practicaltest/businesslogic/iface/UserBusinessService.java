package com.crudopration.practicaltest.businesslogic.iface;

import com.crudopration.practicaltest.common.BaseResponse;
import com.crudopration.practicaltest.model.dto.UserRequestDto;



public interface UserBusinessService {

    public BaseResponse addUser(UserRequestDto user);

    public BaseResponse editUser(String id, UserRequestDto userRequestDto);

    public BaseResponse deleteUser(String id);

    public BaseResponse getAllUser();

    public BaseResponse getOneUser(String id);
    
    
}
