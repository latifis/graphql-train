package com.example.graphqldemo.usecase;

import com.example.graphqldemo.domain.CarCatalogueEntity;
import com.example.graphqldemo.domain.CarEntity;
import com.example.graphqldemo.repository.pgsql.CarCatalogueRepository;
import com.example.graphqldemo.repository.pgsql.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarCatalogueRepository catalogueRepository;

    public CarService(CarRepository carRepository, CarCatalogueRepository catalogueRepository) {
        this.carRepository = carRepository;
        this.catalogueRepository = catalogueRepository;
    }

    public List<CarEntity> getCars(boolean needBrandOrType) {
        return needBrandOrType ? carRepository.findAllWithBrandAndType()
                : carRepository.findAllPlain();
    }

    public Optional<CarEntity> getCarById(Long id, boolean needBrandOrType) {
        return needBrandOrType ? carRepository.findByIdWithBrandAndType(id)
                : carRepository.findByIdPlain(id);
    }

    public List<CarCatalogueEntity> getCatalogues(boolean needCar) {
        return needCar ? catalogueRepository.findAllWithCar()
                : catalogueRepository.findAllPlain();
    }

    public Optional<CarCatalogueEntity> getCatalogueById(Long id, boolean needCar) {
        return needCar ? catalogueRepository.findByIdWithCar(id)
                : catalogueRepository.findByIdPlain(id);
    }
}
