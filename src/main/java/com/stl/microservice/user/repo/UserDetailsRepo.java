package com.stl.microservice.user.repo;

import com.stl.microservice.user.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserDetailsRepo extends JpaRepository<UserDetails,Long> {
    @Query(value="SELECT * FROM tbl_user_details WHERE user_id=?",nativeQuery = true)
    public UserDetails findByUserId(Long USER_ID);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tbl_user_details SET user_status=? WHERE user_id=?",nativeQuery = true)
    public void updateUserStatusByUserId(int Status,String UID);
}
