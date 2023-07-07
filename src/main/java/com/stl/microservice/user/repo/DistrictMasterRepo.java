package com.stl.microservice.user.repo;

import com.stl.microservice.user.model.DistrictMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DistrictMasterRepo extends JpaRepository<DistrictMaster,Integer> {
    @Modifying
    @Transactional
    @Query(value="UPDATE tbl_district_master SET status='delete' WHERE district_id=?",nativeQuery = true)
    public void deleteDistrictById(int DID);
}
