package com.crudopration.practicaltest.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserDetailsMappingRequestDto {
    
    private String id;
   
    private String address;
    
    private String city;
    
    private String state;
    
    private String country;
    
    private String pincode;
    
    private String status;
    
    private String userId;
    
    private String userIdName;

    public UserDetailsMappingRequestDto(String id, String address, String city, String state, String country, String pincode, String status, String userId) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.status = status;
        this.userId = userId;
    }
    
    
  
  


}
