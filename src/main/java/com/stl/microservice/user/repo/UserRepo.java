package com.stl.microservice.user.repo;

import com.stl.microservice.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepo extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM tbl_user WHERE unique_id=?",nativeQuery = true)
    public User findByUniqueId(String unique_id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE tbl_user SET password=? WHERE unique_id=?",nativeQuery = true)
    public void resetPassword(String PASS,String UID);
}
