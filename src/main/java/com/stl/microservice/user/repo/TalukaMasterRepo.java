package com.stl.microservice.user.repo;

import com.stl.microservice.user.model.TalukaMaster;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TalukaMasterRepo extends JpaRepository<TalukaMaster,Integer> {
    @Modifying
    @Transactional
    @Query(value="UPDATE tbl_taluka_master SET status='delete' WHERE taluka_id=?",nativeQuery = true)
    public void deleteTalukaById(int TID);
}
