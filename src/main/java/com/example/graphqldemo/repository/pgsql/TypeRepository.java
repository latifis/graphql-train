package com.example.graphqldemo.repository.pgsql;

import com.example.graphqldemo.domain.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
}
