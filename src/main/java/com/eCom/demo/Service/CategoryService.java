package com.eCom.demo.Service;

import com.eCom.demo.Model.Category;
import com.eCom.demo.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo repo;

    public List<Category> getAllCategory(){
        return repo.findAll();
    }

    public void addCategory(Category category){
        repo.save(category);
    }

    public void removeCategory(long id){
        repo.deleteById(id);
    }

    public Optional<Category> GetCategoryById(long id){
        return repo.findById(id);
    }
}
