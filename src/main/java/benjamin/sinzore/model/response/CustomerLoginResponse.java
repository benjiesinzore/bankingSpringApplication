package benjamin.sinzore.model.response;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;


@Entity
@Setter
@Getter
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "sp_CustomerLogin",
        procedureName = "sp_CustomerLogin", parameters = {
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "accountNumberIN", type = String.class),
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "userPasswordIN", type = String.class)
})
})
public class CustomerLoginResponse {
    @Id
    String timestamp = String.valueOf(new Date());
    int status = 500;
    String error = "Internal Sever error.";
    String message = "Poor internet connection.";
}
