package benjamin.sinzore.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
@Getter
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "sp_CustomerRegistration",
        procedureName = "sp_CustomerRegistration", parameters = {
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "userIDIN", type = int.class),
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "userNameIN", type = String.class),
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "userPasswordIN", type = String.class),
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "userEmailAddressIN", type = String.class)
})
})
public class CustomerRegistrationResponse {
    @Id
    String timestamp ;
    int status = 200;
    String error;
    String message;
}
