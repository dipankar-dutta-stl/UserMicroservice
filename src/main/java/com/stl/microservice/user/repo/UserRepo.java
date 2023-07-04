package com.stl.microservice.user.repo;

import com.stl.microservice.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
