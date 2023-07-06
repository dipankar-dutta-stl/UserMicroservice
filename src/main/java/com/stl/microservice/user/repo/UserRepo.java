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
    @Query(value="SELECT role_id FROM tbl_user WHERE unique_id=?",nativeQuery = true)
    public String findRoleIdByUniqueId(String UID);

    @Query(value="SELECT user_id FROM tbl_user WHERE unique_id=?",nativeQuery = true)
    public Long findUserIdByUniqueId(String UID);

    @Query(value = "SELECT user_status FROM tbl_user WHERE unique_id=?",nativeQuery = true)
    public int getUserStatusByUniqueId(String UNIQUE_ID);

    @Modifying
    @Transactional
    @Query(value="UPDATE tbl_user SET user_status=? WHERE user_id=?",nativeQuery = true)
    public void updateUserStatusByUserId(int Status,String UID);

    @Query(value="SELECT role_id FROM tbl_user WHERE unique_id=?",nativeQuery = true)
    public int findRoleByUniqueId(String UID);

}
