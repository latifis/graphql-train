package com.example.graphqldemo.repository.pgsql;

import com.example.graphqldemo.domain.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<CarEntity, Long> {

    @Query("select c from CarEntity c")
    List<CarEntity> findAllPlain();

    @Query("select c from CarEntity c join fetch c.brand b join fetch c.type t")
    List<CarEntity> findAllWithBrandAndType();

    @Query("select c from CarEntity c where c.id = :id")
    Optional<CarEntity> findByIdPlain(Long id);

    @Query("select c from CarEntity c join fetch c.brand b join fetch c.type t where c.id = :id")
    Optional<CarEntity> findByIdWithBrandAndType(Long id);
}
