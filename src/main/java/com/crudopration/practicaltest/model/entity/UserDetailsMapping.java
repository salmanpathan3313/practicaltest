package com.crudopration.practicaltest.model.entity;

import lombok.Data;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "packages_features")
@Data
@ToString
public class UserDetailsMapping  {
    
        
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "pincode")
    private String pincode;
    
    @Column(name = "status")
    private String status;
    
    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;
    
}
