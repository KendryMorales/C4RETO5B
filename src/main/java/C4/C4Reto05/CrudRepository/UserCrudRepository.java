package C4.C4Reto05.CrudRepository;

import C4.C4Reto05.Model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author KENDRY
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
    //Profundizar en Query methods
    //?0 se le va a pasar un parametro
//    @Query("{email:?0}")

    Optional<User> findByEmail(String email);
//    @Query("{email:?0, password:?1}")

    Optional<User> findByEmailAndPassword(String email, String password);
    //Para seleccionar el usuario con el id maximo

    Optional<User> findTopByOrderByIdDesc();

    List<User> findByMonthBirthtDay(String month);
}
