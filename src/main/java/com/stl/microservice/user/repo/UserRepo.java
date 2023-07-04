package com.stl.microservice.user.repo;

import com.stl.microservice.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM tbl_user WHERE unique_id=?")
    public User findByUniqueId(String unique_id);
}
