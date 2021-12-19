package C4.C4Reto05.Controller;

import C4.C4Reto05.Model.Supplement;
import C4.C4Reto05.Service.SupplementService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KENDRY
 */
@RestController
@RequestMapping("/api/supplements")
@CrossOrigin("*")
public class SupplementController {
       @Autowired
    private SupplementService supplementService;
       
     @GetMapping("/all")
    public List<Supplement> getAll() {
        return supplementService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Supplement> getProduct(@PathVariable("reference") String reference) {
        return supplementService.getProduct(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplement create(@RequestBody Supplement gadget) {
        return supplementService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplement update(@RequestBody Supplement gadget) {
        return supplementService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return supplementService.delete(reference);
    } 
    
        @GetMapping("/price/{price}")
    public List<Supplement> getByPrice(@PathVariable("price") double price){
        return supplementService.getByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<Supplement> getByDescriptionContains(@PathVariable("description") String description){
        return supplementService.getByDescriptionContains(description);
    }
    
}
