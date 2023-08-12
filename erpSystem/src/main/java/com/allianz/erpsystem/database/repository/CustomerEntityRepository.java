package com.allianz.erpsystem.database.repository;

import com.allianz.erpsystem.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByUuid(UUID uuid);
}
