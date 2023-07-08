package com.stl.microservice.user.repo;

import com.stl.microservice.user.model.VillageMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface VillageMasterRepo extends JpaRepository<VillageMaster,Integer> {

    @Modifying
    @Transactional
    @Query(value="UPDATE tbl_village_master SET status='delete' WHERE village_id=?",nativeQuery = true)
    public void deleteVillageById(int VID);
}
