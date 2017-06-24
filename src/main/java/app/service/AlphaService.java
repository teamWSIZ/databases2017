package app.service;


import app.model.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Przykład klasy warstwy serwisowej. Ma ona dostęp do repozytoriów i realizuje bardziej skomplikowane
 * zadania (niż same repozytoria).
 */
@Component  //annotacja powodująca, że instancja tej klasy zostanie automatycznie stworzona przez spring
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
