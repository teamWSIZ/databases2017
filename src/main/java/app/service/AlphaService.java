package app.service;


import app.model.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class AlphaService {
    @Autowired
    ProductRepo productRepo;

    public void showProducts() {
        productRepo.findAll().forEach(System.out::println);
    }
}
