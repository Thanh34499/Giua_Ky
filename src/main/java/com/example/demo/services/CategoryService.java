package com.example.demo.services;

import com.example.demo.entity.Category;
import com.example.demo.repository.ICategotyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private ICategotyRepository categoryRepository;
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
    public Category createCategory(Category category){ return categoryRepository.save(category);}
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
    public  void  updateCategory(Category category) { categoryRepository.save(category);}

}
