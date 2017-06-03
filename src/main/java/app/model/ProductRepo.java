package app.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Integer> {
    //Napisać metody zwracające produkty po categoryid, oraz po productname
    // (dla productname napisać typu "contains")
    @Query("select p.productid from Product p")
    List<Integer> getProductIds();
}
