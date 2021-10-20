package com.su.hydrangea.domain.user.repository;

import com.su.hydrangea.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
