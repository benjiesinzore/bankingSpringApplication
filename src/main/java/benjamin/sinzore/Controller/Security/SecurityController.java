package benjamin.sinzore.Controller.Security;

import benjamin.sinzore.Service.Services;
import benjamin.sinzore.model.RequestBody.*;
import benjamin.sinzore.model.response.*;
import com.mongodb.internal.async.function.AsyncCallbackFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("BankApi")
public class SecurityController {

	@Autowired
	public final Services services;
	public SecurityController(Services services) {
		this.services = services;
	}


	@PostMapping("CustomerRegistration")
	public CustomerRegistrationResponse CustomerRegistration(@RequestBody CustomerRegistrationModel regModel){

		return services.CustomerRegistration(regModel);
	}

	
	@PostMapping("CustomerLogin")
	public CustomerLoginResponse CustomerLogin(@RequestBody CustomerRegistrationModel loginModel){

		return services.CustomerLogin(loginModel);
	}

	
	@PostMapping("BankEmployeeRegistration")
	public BankEmployeeRegistrationResponse BankEmployeeRegistration(@RequestBody BankEmployeeRegistrationModel regModel){

		return services.BankEmployeeRegistration(regModel);
	}
	
	
    @PostMapping("BankEmployeeLoginAndReturnCustomerPendingApproval")
    public BankEmployeeLoginRes BankEmployeeLoginAndReturnCustomerPendingApproval(@RequestBody BankEmployeeRegistrationModel regModel){


        return services.BankEmployeeLoginAndReturnCustomerPendingApproval(regModel);
    }


	@PostMapping("CustomerApproval")
	public CustomerApprovalModel CustomerApproval(@RequestBody CustomerRegistrationModel regModel){

		return services.CustomerApproval(regModel);
	}

	@PostMapping("CustomerTransactionDeposit")
	public CustomerTransaction_Deposit CustomerTransactionDeposit(@RequestBody CustomerTransaction_DepositReq regModel){
		return services.CustomerTransaction_Deposit(regModel);
	}

	@PostMapping("CustomerTransactionWithdraw")
	public CustomerTransaction_Withdraw CustomerTransactionWithdraw(@RequestBody CustomerTransaction_WithdrawReq regModel){
		return services.CustomerTransaction_Withdraw(regModel);
	}

	@PostMapping("CustomerTransaction_TransferFunds")
	public CustomerTransaction_TransferFunds CustomerTransaction_TransferFunds(@RequestBody CustomerTransaction_TransferFundsReq regModel){
		return services.CustomerTransaction_TransferFunds(regModel);
	}

}




//CREATE SCHEMA `bankAccountTest` ;
//
//CREATING A SCHEMA
//CREATE SCHEMA `bankAccountTest` ;

