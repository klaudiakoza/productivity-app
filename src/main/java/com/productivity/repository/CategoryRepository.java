package com.productivity.repository;

import com.productivity.model.Category;
import java.util.HashMap;
import java.util.Collection;

public class CategoryRepository {

    private HashMap<Integer, Category> categories = new HashMap<>();

    // Add category
    public void addCategory(Category category) {
        categories.put(category.getId(), category);
    }

    // Find category by ID
    public Category getCategoryById(int id) {
        return categories.get(id);
    }

    // Get all categories
    public Collection<Category> getAllCategories() {
        return categories.values();
    }

    // Remove category
    public void removeCategory(int id) {
        categories.remove(id);
    }
}
