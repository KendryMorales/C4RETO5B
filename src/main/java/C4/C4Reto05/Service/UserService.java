package C4.C4Reto05.Service;

import C4.C4Reto05.Model.User;
import C4.C4Reto05.Repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KENDRY
 */
@Service
public class UserService {

    /**
     * 
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * 
     * @return 
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }

    /**
     * 
     * @param idUse
     * @return 
     */
    public Optional<User> getUser(int idUse) {
        return userRepository.getUser(idUse);
    }

    /**
     * 
     * @param user
     * @return 
     */
    public User create(User user) {

        Optional<User> userIdMaximo = userRepository.lastUserId();
        if (user.getId() == null) {

            if (userIdMaximo.isEmpty()) {
                user.setId(1);
            } else {
                user.setId(userIdMaximo.get().getId() + 1);
            }
        }

        Optional<User> variable = userRepository.getUser(user.getId());
        if (variable.isEmpty()) {
            if (emailExists(user.getEmail()) == false) {
                return userRepository.create(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    /**
     * 
     * @param user
     * @return 
     */
    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }

                if (user.getBirthtDay() != null) {
                    userDb.get().setBirthtDay(user.getBirthtDay());
                }

                if (user.getMonthBirthtDay() != null) {
                    userDb.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }

                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    userDb.get().setType(user.getType());
                }

                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    /**
     * 
     * @param userId
     * @return 
     */
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * 
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    
        public List<User> getByMonthBirthDay(String month){
        return userRepository.getByMonthBirthDay(month);
    }
}
