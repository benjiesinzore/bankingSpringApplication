package benjamin.sinzore.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "sp_CustomerTransactionDetails_Deposit",
        procedureName = "sp_CustomerTransactionDetails_Deposit", parameters = {
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "accountNumberIN", type = String.class),
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "amountIN", type = int.class)
})
})
public class CustomerTransaction_Deposit {
    @Id
    String timestamp ;
    int status = 200;
    String error;
    String message;
}
