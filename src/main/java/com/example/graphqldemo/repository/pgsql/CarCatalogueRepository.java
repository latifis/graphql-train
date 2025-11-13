package com.example.graphqldemo.repository.pgsql;

import com.example.graphqldemo.domain.CarCatalogueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarCatalogueRepository extends JpaRepository<CarCatalogueEntity, Long> {

    @Query("select cc from CarCatalogueEntity cc")
    List<CarCatalogueEntity> findAllPlain();

    // fetch car when car field requested
    @Query("select cc from CarCatalogueEntity cc join fetch cc.car c")
    List<CarCatalogueEntity> findAllWithCar();

    @Query("select cc from CarCatalogueEntity cc where cc.id = :id")
    Optional<CarCatalogueEntity> findByIdPlain(Long id);

    @Query("select cc from CarCatalogueEntity cc join fetch cc.car c where cc.id = :id")
    Optional<CarCatalogueEntity> findByIdWithCar(Long id);
}
