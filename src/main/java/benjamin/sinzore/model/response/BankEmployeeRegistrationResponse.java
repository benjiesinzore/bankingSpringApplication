package benjamin.sinzore.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
@Getter
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "sp_BankEmployeeRegistrationDetails",
        procedureName = "sp_BankEmployeeRegistrationDetails", parameters = {
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "employeeIDIN", type = String.class),
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "employeePasswordIN", type = String.class),
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "employeeNameIN", type = String.class),
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "employeeCapacityIN", type = String.class)
})
})
public class BankEmployeeRegistrationResponse {
    @Id
    String timestamp ;
    int status = 200;
    String error;
    String message;
}
