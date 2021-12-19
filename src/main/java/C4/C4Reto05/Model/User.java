package C4.C4Reto05.Model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author KENDRY
 */

@Document(collection = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Integer id;
//   @NonNull
    @Field(name = "identificacion")
    private String identification;
    
    @Field(name = "nombre")
    private String name;
    
    @Field(name = "cumpleaños")
    private Date birthtDay;
    
    @Field(name = "mesCumpleaño")
    private String monthBirthtDay;
   
    @Field(name = "direccion")
    private String address;
    
    @Field(name = "celular")
    private String cellPhone;
    
    @Field(name = "correo")
    private String email;
    
    @Field(name = "contraseña")
    private String password;
    
    @Field(name = "zona")
    private String zone;
    
    @Field(name = "tipo")
    private String type;
}
