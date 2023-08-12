package com.allianz.erpsystem.database.repository;

import com.allianz.erpsystem.database.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;
import java.util.UUID;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findByUuid(UUID uuid);

    @Modifying
    void deleteByUuid(UUID uuid);
}
