package com.example.graphqldemo.repository.pgsql;

import com.example.graphqldemo.domain.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
}
