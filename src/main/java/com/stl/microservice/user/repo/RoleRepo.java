package com.stl.microservice.user.repo;

import com.stl.microservice.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer> {
}
