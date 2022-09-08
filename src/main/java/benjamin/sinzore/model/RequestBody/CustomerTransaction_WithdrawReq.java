package benjamin.sinzore.model.RequestBody;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("deprecation")
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class CustomerTransaction_WithdrawReq {
    String AccountNumber;
    int Amount;
    String CreatedOn;
}
