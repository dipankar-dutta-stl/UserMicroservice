package com.stl.microservice.user.repo;

import com.stl.microservice.user.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<UserDetails,Long> {
}
