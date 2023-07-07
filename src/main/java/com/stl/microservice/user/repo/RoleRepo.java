package com.stl.microservice.user.repo;

import com.stl.microservice.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepo extends JpaRepository<Role,Integer> {

    @Modifying
    @Transactional
    @Query(value="UPDATE tbl_role SET status=? WHERE role_id=?",nativeQuery = true)
    public void deleteRoleById(String status,int ROLE_ID);
}
