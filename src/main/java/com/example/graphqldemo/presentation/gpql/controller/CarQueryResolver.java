package com.example.graphqldemo.presentation.gpql.controller;

import com.example.graphqldemo.domain.CarCatalogueEntity;
import com.example.graphqldemo.domain.CarEntity;
import com.example.graphqldemo.usecase.CarService;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.SelectedField;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.stream.Collectors;


@Controller
public class CarQueryResolver {

    private final CarService carService;

    public CarQueryResolver(CarService carService) {
        this.carService = carService;
    }

    @QueryMapping
    public List<CarEntity> getCars(DataFetchingEnvironment env) {
        Set<String> fields = env.getSelectionSet().getFields().stream()
                .map(SelectedField::getName)
                .collect(Collectors.toSet());

        boolean needBrandOrType = fields.contains("brand") || fields.contains("type");
        return carService.getCars(needBrandOrType);
    }

    @QueryMapping
    public CarEntity getCarById(@Argument Long id, DataFetchingEnvironment env) {
        Set<String> fields = env.getSelectionSet().getFields().stream()
                .map(SelectedField::getName)
                .collect(Collectors.toSet());
        boolean needBrandOrType = fields.contains("brand") || fields.contains("type");
        Optional<CarEntity> opt = carService.getCarById(id, needBrandOrType);
        return opt.orElse(null);
    }

    @QueryMapping
    public List<CarCatalogueEntity> getCatalogue(DataFetchingEnvironment env) {
        Set<String> fields = env.getSelectionSet().getFields().stream()
                .map(SelectedField::getName)
                .collect(Collectors.toSet());
        boolean needCar = fields.contains("car");
        return carService.getCatalogues(needCar);
    }

    @QueryMapping
    public CarCatalogueEntity getCatalogueById(@Argument Long id, DataFetchingEnvironment env) {
        Set<String> fields = env.getSelectionSet().getFields().stream()
                .map(SelectedField::getName)
                .collect(Collectors.toSet());
        boolean needCar = fields.contains("car");
        Optional<CarCatalogueEntity> opt = carService.getCatalogueById(id, needCar);
        return opt.orElse(null);
    }
}

