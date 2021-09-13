package com.example.spring5recipeapp.repositories;

import com.example.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepositories extends CrudRepository<Recipe, Long> {
}
