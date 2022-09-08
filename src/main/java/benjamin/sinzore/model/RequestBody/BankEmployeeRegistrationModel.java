package benjamin.sinzore.model.RequestBody;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("deprecation")
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class BankEmployeeRegistrationModel {

    String EmployeeID;
    String EmployeePassword;
    String EmployeeName;
    String EmployeeCapacity;
}
