package com.eCom.demo.Repository;

import com.eCom.demo.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long> {
    List<Products> findByCategory_Id(long id);
}
