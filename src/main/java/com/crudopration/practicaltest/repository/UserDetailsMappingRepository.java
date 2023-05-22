package com.crudopration.practicaltest.repository;

import com.crudopration.practicaltest.model.entity.UserDetailsMapping;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailsMappingRepository extends JpaRepository<UserDetailsMapping, String> {

    @Query(nativeQuery = true, value="SELECT * FROM crud_oprations.user_details where user_id=?1 and status in ?2")
    public List<UserDetailsMapping> findByUserIdAndStatusIn(String userId, List<String> status);


}
