package benjamin.sinzore.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class BankEmployeeLoginRes {
    int status = 500;
    String message =  "Poor internet Connection";
    String error = "Internal Server Error";
    List data;
}


