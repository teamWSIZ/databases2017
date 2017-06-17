package app.service;


import app.model.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Przykład klasy warstwy serwisowej. Ma ona dostęp do repozytoriów i realizuje bardziej skomplikowane
 * zadania (niż same repozytoria).
 */
public class AlphaService {
    @Autowired
    ProductRepo productRepo;

    public void showProducts() {
//        productRepo.findAll().forEach(System.out::println);
    }

    public int add(int a, int b) {
        return a + b;
    }
}
