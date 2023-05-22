package com.crudopration.practicaltest.model.dto;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserRequestDto {
    
    private String id;
   
    private String userName;
    
    private String mobile;
    
    private String status;
    
    private String email;
    
    private List<UserDetailsMappingRequestDto> userDetailsField;

    public UserRequestDto(String id, String userName, String mobile, String status, String email, List<UserDetailsMappingRequestDto> userDetailsField) {
        this.id = id;
        this.userName = userName;
        this.mobile = mobile;
        this.status = status;
        this.email = email;
        this.userDetailsField = userDetailsField;
    }

    
    
  


}
