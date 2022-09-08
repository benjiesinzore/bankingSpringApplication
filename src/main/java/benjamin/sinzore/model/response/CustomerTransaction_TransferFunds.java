package benjamin.sinzore.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "sp_CustomerTransaction_TransferFunds",
        procedureName = "sp_CustomerTransaction_TransferFunds", parameters = {
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "accountNumberIN", type = String.class),
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "accountNumberToSendToIN", type = String.class),
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "amountIN", type = int.class),
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "createdOnIN", type = String.class)
})
})
public class CustomerTransaction_TransferFunds {
    @Id
    String timestamp ;
    int status = 200;
    String error;
    String message;
}
