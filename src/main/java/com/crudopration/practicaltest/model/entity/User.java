package com.crudopration.practicaltest.model.entity;

import java.util.List;
import lombok.Data;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "packages")
@Data
@ToString
public class User{

     @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    
    @Column(name = "user_name")
    private String userName;
    
    @Column(name = "mobile")
    private String mobile;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "status")
    private String status;
    

    
//    @Override
//    public void preInsert() {
//        super.preInsert();
//    }
//
//    @Override
//    public void preUpdate() {
//        super.preUpdate();
//    }
}
