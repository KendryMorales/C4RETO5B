package C4.C4Reto05.Service;

import C4.C4Reto05.Model.Supplement;
import C4.C4Reto05.Repository.SupplementRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KENDRY
 */
@Service
public class SupplementService {

    @Autowired
    private SupplementRepository supplementRepository;

    public List<Supplement> getAll() {
        return supplementRepository.getAll();
    }

    public Optional<Supplement> getProduct(String reference) {
        return supplementRepository.getProduct(reference);
    }

    public Supplement create(Supplement product) {
        if (product.getReference() == null) {
            return product;
        } else {
            return supplementRepository.create(product);
        }
    }

    public Supplement update(Supplement product) {

        if (product.getReference() != null) {
            Optional<Supplement> productDb = supplementRepository.getProduct(product.getReference());
            if (!productDb.isEmpty()) {

                if (product.getBrand() != null) {
                    productDb.get().setBrand(product.getBrand());
                }

                if (product.getCategory() != null) {
                    productDb.get().setCategory(product.getCategory());
                }

                if (product.getObjetivo() != null) {
                    productDb.get().setObjetivo(product.getObjetivo());
                }

                if (product.getDescription() != null) {
                    productDb.get().setDescription(product.getDescription());
                }

                if (product.getPrice() != 0.0) {
                    productDb.get().setPrice(product.getPrice());
                }

                if (product.getQuantity() != 0) {
                    productDb.get().setQuantity(product.getQuantity());
                }

                if (product.getPhotography() != null) {
                    productDb.get().setPhotography(product.getPhotography());
                }

                productDb.get().setAvailability(product.isAvailability());
                supplementRepository.update(productDb.get());
                return productDb.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getProduct(reference).map(product -> {
            supplementRepository.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Supplement> getByPrice(double price) {
        return supplementRepository.getByPrice(price);
    }

    public List<Supplement> getByDescriptionContains(String description) {
        return supplementRepository.getByDescriptionContains(description);
    }

}
