package com.stl.microservice.user.repo;

import com.stl.microservice.user.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDetailsRepo extends JpaRepository<UserDetails,Long> {
    @Query(value="SELECT * FROM tbl_user_details WHERE user_id=?",nativeQuery = true)
    public UserDetails findByUserId(Long USER_ID);
}
