package com.example.spring5recipeapp.converters;

import com.example.spring5recipeapp.commands.IngredientCommand;
import com.example.spring5recipeapp.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasurementCommandToUnitOfMeasurement uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasurementCommandToUnitOfMeasurement uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUom(uomConverter.convert(source.getUnitOfMeasure()));
        return ingredient;
    }

}
