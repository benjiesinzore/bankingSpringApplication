package benjamin.sinzore.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Setter
@Getter
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "sp_GetAvailableBalance",
        procedureName = "sp_GetAvailableBalance", parameters = {
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "accountNumberIN", type = BigInteger.class)
})
})
public class CustomerTransaction_GetAvailableBalanceRes {
    @Id
    String timestamp ;
    int status = 200;
    String error;
    String message;
}
