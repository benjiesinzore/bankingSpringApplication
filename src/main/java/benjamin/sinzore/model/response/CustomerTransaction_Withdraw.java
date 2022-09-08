package benjamin.sinzore.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "sp_CustomerTransaction_Withdraw",
        procedureName = "sp_CustomerTransaction_Withdraw", parameters = {
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "accountNumberIN", type = String.class),
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "amountIN", type = int.class),
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "createdOnIN", type = String.class)
})
})
public class CustomerTransaction_Withdraw {
    @Id
    String timestamp ;
    int status = 200;
    String error;
    String message;
}
