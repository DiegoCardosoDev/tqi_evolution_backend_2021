package com.system.repositories;

import com.system.model.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserClientRepository extends JpaRepository<UserClient, Integer> {
}
