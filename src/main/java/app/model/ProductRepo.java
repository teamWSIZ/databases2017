package app.model;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Integer> {
    //Napisać metody zwracające produkty po categoryid, oraz po productname
    // (dla productname napisać typu "contains")
}
