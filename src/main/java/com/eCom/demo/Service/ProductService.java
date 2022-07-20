package com.eCom.demo.Service;

import com.eCom.demo.Model.Category;
import com.eCom.demo.Model.Products;
import com.eCom.demo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Products> getAllProduct(){
        return repo.findAll();
    }

    public void addProduct(Products product){
        repo.save(product);
    }

    public void removeProduct(long id){
        repo.deleteById(id);
    }

    public Optional<Products> GetProductById(long id){
        return repo.findById(id);
    }

    public List<Products> GetAllProductsByCategoryId(long id){
        return repo.findByCategory_Id(id);
    }
}
