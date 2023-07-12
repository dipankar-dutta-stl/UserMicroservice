package com.stl.microservice.user.repo;

import com.stl.microservice.user.model.GramPanchayat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface GramPanchayatRepo extends JpaRepository<GramPanchayat,Long> {

    @Modifying
    @Transactional
    @Query(value="UPDATE tbl_gram_panchayat SET status='delete' WHERE panchayat_id=?",nativeQuery = true)
    public void deleteGramPanchayatById(int DID);
}
