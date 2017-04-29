package app.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShipperRepo extends CrudRepository<Shipper, Integer> {

    List<Shipper> getByShippernameContaining(String text);

    @Query("select s.shipperid from Shipper s")
    public List<Integer> getShipperIds();
}
