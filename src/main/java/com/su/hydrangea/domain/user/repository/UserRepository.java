package com.su.hydrangea.domain.user.repository;

import com.su.hydrangea.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
