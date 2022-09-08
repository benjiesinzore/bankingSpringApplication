package benjamin.sinzore.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table
@Setter
@Getter
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "sp_BankEmployeeLogin",
        procedureName = "sp_BankEmployeeLogin", parameters = {
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "employeeIDIN", type = String.class),
        @StoredProcedureParameter(	mode = ParameterMode.IN, name = "employeePasswordIN", type = String.class)
})
})
public class BankEmployeeLoginModelListOfCustomersPendingApproval {

    @Id
    String accountNumber;
    int userID;
    String userName;
    String userPassword;
    String userEmailAddress;
    String status;
}
