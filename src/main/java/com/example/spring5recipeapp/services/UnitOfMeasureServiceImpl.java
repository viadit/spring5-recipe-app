package com.example.spring5recipeapp.services;

import com.example.spring5recipeapp.commands.UnitOfMeasurementCommand;
import com.example.spring5recipeapp.converters.UnitOfMeasurementToUnitOfMeasurementCommand;
import com.example.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService{

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasurementToUnitOfMeasurementCommand unitOfMeasurementToUnitOfMeasurementCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
                                    UnitOfMeasurementToUnitOfMeasurementCommand unitOfMeasurementToUnitOfMeasurementCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasurementToUnitOfMeasurementCommand = unitOfMeasurementToUnitOfMeasurementCommand;
    }

    @Override
    public Set<UnitOfMeasurementCommand> listAllUoms() {

        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                .spliterator(), false)
                .map(unitOfMeasurementToUnitOfMeasurementCommand::convert)
                .collect(Collectors.toSet());
    }
}
