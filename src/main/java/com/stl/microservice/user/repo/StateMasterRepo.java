package com.stl.microservice.user.repo;

import com.stl.microservice.user.model.StateMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StateMasterRepo extends JpaRepository<StateMaster,Integer> {

    @Modifying
    @Transactional
    @Query(value="UPDATE tbl_state_master SET status='delete' WHERE state_id=?",nativeQuery = true)
    public void deleteStateMasterById(int SID);
}
