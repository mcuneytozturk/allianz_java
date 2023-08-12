package com.allianz.erpsystem.database.repository;

import com.allianz.erpsystem.database.entity.BillEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillEntityRepository extends JpaRepository<BillEntity, Long> {
}
