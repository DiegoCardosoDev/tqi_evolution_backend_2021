package com.system.repositories;

import com.system.model.Lending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LendingRepository extends JpaRepository<Lending, Integer> {
}
