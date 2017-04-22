package app.model;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDetailRepo extends CrudRepository<UserDetail, Integer> {

    List<UserDetail> getByUserdetailidGreaterThan(Integer id);

    List<UserDetail> getByPeselStartingWith(String ppp);

    //Więcej konwencji do generowania przydatnych metod:
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
    //
    //--> Table 4. Supported keywords inside method names


}
