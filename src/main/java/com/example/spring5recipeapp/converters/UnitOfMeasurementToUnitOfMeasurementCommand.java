package com.example.spring5recipeapp.converters;

import com.example.spring5recipeapp.commands.UnitOfMeasurementCommand;
import com.example.spring5recipeapp.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class UnitOfMeasurementToUnitOfMeasurementCommand implements Converter<UnitOfMeasure, UnitOfMeasurementCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasurementCommand convert(UnitOfMeasure unitOfMeasure) {
        if (unitOfMeasure != null) {
            final UnitOfMeasurementCommand uomc = new UnitOfMeasurementCommand();
            uomc.setId(unitOfMeasure.getId());
            uomc.setDescription(unitOfMeasure.getDescription());
        }
            return null;

    }
}
