package C4.C4Reto05.CrudRepository;

import C4.C4Reto05.Model.Supplement;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author KENDRY
 */
public interface SupplementCrudRepository extends MongoRepository<Supplement, String> {

//    public List<Supplement> findByPrice(double price);
    public List<Supplement> findByPriceLessThanEqual(double precio);

    public List<Supplement> findByDescriptionContainingIgnoreCase(String description);
}
