package com.crudopration.practicaltest.repository;

import com.crudopration.practicaltest.model.entity.User;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    
    @Transactional
    @Query(nativeQuery = true, value = "select * from user where id = ?1")
    public User findByUserId(String id);

    
    @Transactional
    @Query(" SELECT g from User g where status in ?1")
    public List<User> getAllUserList(List<String> status);
    
    @Transactional
    @Query(" SELECT g from User g where mobile = ?1 and status in ?2")
    public List<User> findByUserMobileAndStatusIn(String mobile, List<String> status);
    
}
