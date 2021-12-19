package C4.C4Reto05.CrudRepository;

import C4.C4Reto05.Model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author KENDRY
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {

    //Retorna las ordenes de pedido que coincida con la zona recibida como parametro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);

    //Retorna las ordenes por estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    //Para seleccionar el usuario con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
    
    List<Order> findBySalesManZone(String zone);

}
