package C4.C4Reto05.Repository;

import C4.C4Reto05.CrudRepository.UserCrudRepository;
import C4.C4Reto05.Model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KENDRY
 */
@Repository
public class UserRepository {

    /**
     * 
     */
    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     * 
     * @return 
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     * 
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    /**
     * 
     * @param user
     * @return 
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }

    /**
     * 
     * @param user 
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }

    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    /**
     * 
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    /**
     * 
     * @return 
     */
    public Optional<User> lastUserId() {
        return userCrudRepository.findTopByOrderByIdDesc();
    }

    /**
     * 
     * @param month
     * @return 
     */
    public List<User> getByMonthBirthDay(String month) {
        return userCrudRepository.findByMonthBirthtDay(month);
    }

}
