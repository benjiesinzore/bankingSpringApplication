package benjamin.sinzore.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "sp_ApproveCustomer",
        procedureName = "sp_ApproveCustomer", parameters = {
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "accountNumberIN", type = String.class)
})
})
public class CustomerApprovalModel {
    @Id
    String timestamp ;
    int status = 200;
    String error;
    String message;
}
