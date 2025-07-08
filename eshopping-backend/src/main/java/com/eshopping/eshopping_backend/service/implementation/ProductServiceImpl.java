package com.eshopping.eshopping_backend.service.implementation;

import com.eshopping.eshopping_backend.model.Product;
import com.eshopping.eshopping_backend.repository.ProductRepository;
import com.eshopping.eshopping_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repo  ;
public List <Product> getProducts() {
    return repo.findAll();
}
public  Product getProductByID(Long prodId){
    return repo.findById(prodId).orElse(new  Product());
}
public void  addProduct(Product product) {
   repo.save(product);
}
public void updateProduct(Product product){
    repo.save(product); // Verifier si le product exist bien

}

public void  deleteProduct(Long productId) {
    repo.deleteById(productId);
}
}
