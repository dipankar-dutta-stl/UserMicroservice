package com.stl.microservice.user.repo;

import com.stl.microservice.user.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ModuleRepo extends JpaRepository<Module,Integer> {

    @Modifying
    @Transactional
    @Query(value="UPDATE tbl_module SET module_status='delete' WHERE module_id=?",nativeQuery = true)
    public void deleteModuleById(int MODULE_ID);
}
