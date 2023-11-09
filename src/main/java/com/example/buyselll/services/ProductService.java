package com.example.buyselll.services;

import com.example.buyselll.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID, "PS_5", "Simple description", "Piter", "Igor", 7500));
        products.add(new Product(++ID, "Iphone10", "Simple description", "Voronesh", "Igor", 4500));
    }

    public List<Product> list() {
        return products;
    }

    public void saveProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }
}
